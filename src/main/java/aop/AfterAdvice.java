package aop;

import org.aopalliance.aop.Advice;

/**
 * 后置增强
 * AfterAdvice是在方法执行后执行的通知，无法获取到目标方法的返回值，也无法修改这个返回值。它通常用于执行一些无论目标方法是否抛出异常都需要执行的逻辑，比如清理资源等。
 * @author quincy
 * @create 2023 - 04 - 18 15:52
 */
public interface AfterAdvice extends Advice {
}
