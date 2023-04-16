package aop;

import java.lang.reflect.Method;

/**
 * 方法匹配
 * @author quincy
 * @create 2023 - 04 - 16 14:29
 */
public interface MethodMatcher {

    boolean matches(Method method, Class<?> targetClass);
}
