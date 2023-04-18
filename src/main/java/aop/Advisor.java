package aop;

import org.aopalliance.aop.Advice;

/**
 * Spring中的Advisor是一个特殊的Bean，它实现了Advice接口，并且可以通过Pointcut（切点）指定它要拦截的目标对象和方法。
 * 当目标对象的方法被调用时，Advisor会在方法执行前、执行后或者抛出异常时执行相应的逻辑，例如记录日志、验证用户权限等。
 *
 * Advisor是Advice的容器，它包含了Advice和Pointcut。
 * Pointcut是指对哪些类、方法进行拦截。Advice是具体的拦截逻辑，可以在目标方法执行之前、之后或者抛出异常的执行
 * @author quincy
 * @create 2023 - 04 - 16 15:53
 */
public interface Advisor {

    Advice getAdvice();
}
