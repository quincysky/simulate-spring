package aop.dynamic;

import aop.AdvisedSupport;
import aop.Advisor;
import aop.MethodMatcher;
import aop.TargetSource;
import aop.aspectj.AspectJExpressionPointcut;
import aop.framework.CglibAopProxy;
import aop.framework.JdkDynamicAopProxy;
import beans.BeansException;
import common.WorldServiceInterceptor;
import org.aspectj.apache.bcel.ExceptionConstants;
import org.junit.Test;
import service.WorldService;
import service.WorldServiceImpl;

/**
 * @author quincy
 * @create 2023 - 04 - 16 18:28
 */
public class DynamicProxyTest {

    @Test
    public void testDynamicProxy(){
        WorldService worldService = new WorldServiceImpl();

        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(worldService);
        WorldServiceInterceptor methodInterceptor = new WorldServiceInterceptor();
        MethodMatcher methodMatcher = new AspectJExpressionPointcut("execution(* service.WorldService.explode(..))").getMethodMatcher();
        advisedSupport.setTargetSource(targetSource);
        advisedSupport.setMethodMatcher(methodMatcher);

        WorldService proxy = (WorldService) new CglibAopProxy(advisedSupport).getProxy();
        proxy.explode();
    }
}
