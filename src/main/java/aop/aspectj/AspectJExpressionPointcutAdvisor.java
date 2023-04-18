package aop.aspectj;

import aop.Pointcut;
import aop.PointcutAdvisor;
import org.aopalliance.aop.Advice;

/**
 * aspectj表达式的advisor
 *
 * @author quincy
 * @create 2023 - 04 - 18 14:37
 */
public class AspectJExpressionPointcutAdvisor implements PointcutAdvisor {

    private AspectJExpressionPointcut pointcut;

    private Advice advice;

    private String expression;

    public void setExpression(String expression) {
        this.expression = expression;
    }

    @Override
    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }

    @Override
    public Pointcut getPointcut() {
        if (pointcut == null) {
            pointcut = new AspectJExpressionPointcut(expression);
        }
        return pointcut;
    }
}
