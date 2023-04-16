package aop.aspectj;

import aop.ClassFilter;
import aop.MethodMatcher;
import aop.Pointcut;
import org.aspectj.weaver.tools.PointcutExpression;
import org.aspectj.weaver.tools.PointcutParser;
import org.aspectj.weaver.tools.PointcutPrimitive;

import java.awt.*;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * AspectJExpressionPointcut是支持AspectJ切点表达式的PointCut实现
 * 简单实现仅支持execution函数
 *
 * JointPoint 是织入点，只需要执行代理操作的某个类的某个方法(仅支持方法级别的JoinPoint)
 * Pointcut 是 JoinPoint的表述方式，能捕获JoinPoint.最常见的切点表达式是AspectJ的切点表达式。
 * @author quincy
 * @create 2023 - 04 - 16 14:34
 */
public class AspectJExpressionPointcut implements Pointcut, ClassFilter, MethodMatcher {

    // PointcutPrimitive为AspectJ支持的不同类型的切入点基元的枚举。
    private static final Set<PointcutPrimitive> SUPPORTED_PRIMITIVES = new HashSet<PointcutPrimitive>();

    static {
        SUPPORTED_PRIMITIVES.add(PointcutPrimitive.EXECUTION);
    }


    private final PointcutExpression pointcutExpression;

    public AspectJExpressionPointcut(String expression) {
        // 类加载器的任务是根据一个类的全限定名来读取此类的二进制字节流到JVM中，然后转换为一个与目标类对应的java.lang.Class对象实例
        PointcutParser pointcutParser = PointcutParser.getPointcutParserSupportingSpecifiedPrimitivesAndUsingSpecifiedClassLoaderForResolution(SUPPORTED_PRIMITIVES, this.getClass().getClassLoader());
        pointcutExpression = pointcutParser.parsePointcutExpression(expression);

    }

    @Override
    public boolean matches(Class<?> clazz) {
        return pointcutExpression.couldMatchJoinPointsInType(clazz);
    }

    @Override
    public boolean matches(Method method, Class<?> targetClass) {
        return pointcutExpression.matchesMethodExecution(method).alwaysMatches();
    }

    @Override
    public ClassFilter getClassFilter() {
        return this;
    }

    @Override
    public MethodMatcher getMethodMatcher() {
        return this;
    }
}
