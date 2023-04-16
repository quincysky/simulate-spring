package aop.framework;

import aop.AdvisedSupport;
import org.assertj.core.api.ObjectEnumerableAssert;

import java.lang.reflect.Method;
import java.util.List;

/**
 * 该接口的主要作用是创建advisor链
 * Advisor链是用于拦截方法调用并在调用前后执行一些附加逻辑的AOP实现中的关键部分
 * @author quincy
 * @create 2023 - 04 - 16 15:37
 */
public interface AdvisorChainFactory {

    List<Object> getInterceptorsAndDynamicInterceptionAdvice(AdvisedSupport config, Method method, Class<?> targetClass);
}
