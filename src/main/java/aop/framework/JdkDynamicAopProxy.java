package aop.framework;

import aop.AdvisedSupport;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * 该代理是基于JDK动态代理的具体实现
 * @author quincy
 * @create 2023 - 04 - 16 15:19
 */
public class JdkDynamicAopProxy implements AopProxy, InvocationHandler {

    private final AdvisedSupport advised;

    public JdkDynamicAopProxy(AdvisedSupport advised) {
        this.advised = advised;
    }

    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(getClass().getClassLoader(), advised.getTargetSource().getTargetClass(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 获取目标对象
        Object target = advised.getTargetSource().getTarget();
        Class<?> targetClass = target.getClass();
        Object retVal = null;
        // 获取拦截器链
        List<Object> chain = this.advised.getInterceptorsAndDynamicInterceptionAdvice(method, targetClass);
        if (chain == null || chain.isEmpty()) {
            return method.invoke(target, args);
        } else {
            // 将拦截器统一封装成ReflectiveMethodInvocation
            MethodInvocation invocation =
                    new ReflectiveMethodInvocation(proxy, target, method, args, targetClass, chain);

            // 执行拦截器链
            retVal = invocation.proceed();
        }
        return retVal;
    }
}
