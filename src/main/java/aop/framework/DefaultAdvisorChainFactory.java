package aop.framework;

import aop.AdvisedSupport;
import aop.Advisor;
import aop.MethodMatcher;
import aop.PointcutAdvisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.assertj.core.api.ObjectEnumerableAssert;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author quincy
 * @create 2023 - 04 - 16 15:49
 */
public class DefaultAdvisorChainFactory implements AdvisorChainFactory{

    /**
     * 返回指定方法的MethodInterceptors
     * @param config
     * @param method
     * @param targetClass
     * @return
     */
    @Override
    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(AdvisedSupport config, Method method, Class<?> targetClass) {
        Advisor[] advisors = config.getAdvisors().toArray(new Advisor[0]);
        List<Object> interceptorList = new ArrayList<>(advisors.length);
        Class<?> actualClass = (targetClass != null) ? targetClass : method.getDeclaringClass();
        for (Advisor advisor : advisors) {
            if (advisor instanceof PointcutAdvisor) {
                PointcutAdvisor pointcutAdvisor = (PointcutAdvisor) advisor;
                //检验当前Advisor是否适用于当前对象
                if (pointcutAdvisor.getPointcut().getClassFilter().matches(actualClass)) {
                    MethodMatcher mm = pointcutAdvisor.getPointcut().getMethodMatcher();
                    // 校验Advisor是否应用到当前方法上
                    boolean match = mm.matches(method, actualClass);
                    if (match) {
                        MethodInterceptor interceptor = (MethodInterceptor) advisor.getAdvice();
                        interceptorList.add(interceptor);
                    }
                }
            }
        }
        return interceptorList;
    }
}
