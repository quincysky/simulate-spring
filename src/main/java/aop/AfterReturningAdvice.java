package aop;

import org.assertj.core.api.ObjectEnumerableAssert;

import java.lang.reflect.Method;

/**
 * 后置增强
 * AfterReturnAdvice是在目标方法正常返回结果后执行的通知，可以获取目标方法的返回值，并且可以修改这个返回值。通常用于执行一些收尾工作。比如清理资源、记录日志等
 * @author quincy
 * @create 2023 - 04 - 18 15:53
 */
public interface AfterReturningAdvice extends AfterAdvice{

    void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable;
}
