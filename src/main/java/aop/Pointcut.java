package aop;

/**
 * 切点抽象
 *
 * @author quincy
 * @create 2023 - 04 - 16 14:27
 */
public interface Pointcut {

    ClassFilter getClassFilter();

    MethodMatcher getMethodMatcher();
}
