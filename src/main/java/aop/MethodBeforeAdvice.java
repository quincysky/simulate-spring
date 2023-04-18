package aop;

import javax.management.openmbean.OpenMBeanAttributeInfo;
import java.lang.reflect.Method;

/**
 * @author quincy
 * @create 2023 - 04 - 18 15:59
 */
public interface MethodBeforeAdvice extends BeforeAdvice{

    void before(Method method, Object[] args, Object target) throws Throwable;
}
