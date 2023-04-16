package aop;

import org.aopalliance.aop.Advice;

/**
 * @author quincy
 * @create 2023 - 04 - 16 15:53
 */
public interface Advisor {

    Advice getAdvice();
}
