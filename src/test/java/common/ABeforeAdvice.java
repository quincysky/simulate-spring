package common;

import aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author quincy
 * @create 2023 - 04 - 20 20:07
 */
public class ABeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("this is a ABMethodBeforeAdvice");
    }
}
