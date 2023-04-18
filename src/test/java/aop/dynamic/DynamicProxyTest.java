package aop.dynamic;

import aop.*;
import aop.adapter.MethodBeforeAdviceInterceptor;
import aop.aspectj.AspectJExpressionPointcut;
import aop.aspectj.AspectJExpressionPointcutAdvisor;
import aop.framework.CglibAopProxy;
import aop.framework.JdkDynamicAopProxy;
import aop.framework.ProxyFactory;
import beans.BeansException;
import cn.hutool.extra.tokenizer.Word;
import common.WorldServiceBeforeAdvice;
import common.WorldServiceInterceptor;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.aspectj.weaver.World;
import org.junit.Before;
import org.junit.Test;
import service.WorldService;
import service.WorldServiceImpl;

/**
 * @author quincy
 * @create 2023 - 04 - 16 18:28
 */
public class DynamicProxyTest {

    private AdvisedSupport advisedSupport;

    @Before
    public void setup() {
        WorldService worldService = new WorldServiceImpl();

        advisedSupport = new ProxyFactory();
        // Advisor是Pointcut和Advice的组合
        String expression = "execution(* service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        WorldServiceInterceptor interceptor = new WorldServiceInterceptor();
        advisor.setAdvice(interceptor);
        TargetSource targetSource = new TargetSource(worldService);
        advisedSupport.setTargetSource(targetSource);
    }

    @Test
    public void testJDKDynamicProxy(){
        WorldService proxy = (WorldService) new JdkDynamicAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }

    @Test
    public void testCGLibDynamicProxy() {
        Object proxy = new CglibAopProxy(advisedSupport).getProxy();
        ((WorldService)proxy).explode();
    }

    @Test
    public void testProxyFactory() {
        // 使用JDk动态代理
        ProxyFactory factory = (ProxyFactory) this.advisedSupport;
        factory.setProxyTargetClass(false);
        Object proxy = factory.getProxy();
        ((WorldService) proxy).explode();

        // 使用CGLib动态代理
        factory.setProxyTargetClass(true);
        proxy = factory.getProxy();
        ((WorldService) proxy).explode();
    }

    @Test
    public void testBeforeAdvice() throws Exception {
        // 设置BeforeAdvice
        String expression = "execution(* service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodBeforeAdviceInterceptor);
        advisedSupport.addAdvisor(advisor);
        ProxyFactory factory = (ProxyFactory) advisedSupport;
        WorldService proxy = (WorldService)factory.getProxy();
        proxy.explode();
    }

    @Test
    public void testAdvisor() throws Exception {
        WorldService worldService = new WorldServiceImpl();

        String expression = "execution(* service.WorldService.explode(..))";
        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression(expression);
        MethodBeforeAdviceInterceptor methodBeforeAdviceInterceptor = new MethodBeforeAdviceInterceptor(new WorldServiceBeforeAdvice());
        advisor.setAdvice(methodBeforeAdviceInterceptor);

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(worldService.getClass())) {
            ProxyFactory proxyFactory = new ProxyFactory();

            TargetSource targetSource = new TargetSource(worldService);
            proxyFactory.setTargetSource(targetSource);
            proxyFactory.addAdvisor(advisor);

            WorldService proxy = (WorldService) proxyFactory.getProxy();
            proxy.explode();
        }
    }
}
