package common;

import aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author quincy
 * @create 2023 - 04 - 18 16:06
 */
public class WorldServiceBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("BeforeAdvice: do something before the earth explodes");
    }
}
