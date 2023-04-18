package aop;

/**
 * Pointcut用于捕获JoinPoint
 *
 * @author quincy
 * @create 2023 - 04 - 16 14:27
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
