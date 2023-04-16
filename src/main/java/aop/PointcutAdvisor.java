package aop;

/**
 * @author quincy
 * @create 2023 - 04 - 16 16:22
 */
public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();
}
