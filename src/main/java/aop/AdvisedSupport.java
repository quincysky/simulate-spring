package aop;

import aop.framework.AdvisorChainFactory;
import aop.framework.DefaultAdvisorChainFactory;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AdvisedSupport的主要作用是为AOP代理提供支持。
 * AdvisedSupport提供了AOP代理所需的所有基础设施。这些基础包括目标对象、AOP拦截器链、advisor列表、目标类、目标方法以及方法匹配器
 * @author quincy
 * @create 2023 - 04 - 16 15:23
 */
public class AdvisedSupport {

    // 是否使用cglib代理
    private boolean proxyTargetClass = true;

    private TargetSource targetSource;

    private MethodMatcher methodMatcher;


    // transient关键字的作用是告诉java编译器，在对象序列化的过程中，这个字段不需要被序列化
    private transient Map<Integer, List<Object>> methodCache;

    AdvisorChainFactory advisorChainFactory = new DefaultAdvisorChainFactory();

    private List<Advisor> advisors = new ArrayList<>();

    public AdvisedSupport() {
        this.methodCache = new ConcurrentHashMap<>(32);
    }

    public boolean isProxyTargetClass() {
        return proxyTargetClass;
    }

    public void setProxyTargetClass(boolean proxyTargetClass) {
        this.proxyTargetClass = proxyTargetClass;
    }

    public void addAdvisor(Advisor advisor) {
        advisors.add(advisor);
    }

    public List<Advisor> getAdvisors() {
        return advisors;
    }

    public TargetSource getTargetSource(){
        return targetSource;
    }

    public void setTargetSource(TargetSource targetSource) {
        this.targetSource = targetSource;
    }

    public MethodMatcher getMethodMatcher() {
        return methodMatcher;
    }

    public void setMethodMatcher(MethodMatcher methodMatcher) {
        this.methodMatcher = methodMatcher;
    }

    /**
     * 返回方法的拦截器链
     * @param method
     * @param targetClass
     * @return
     */
    public List<Object> getInterceptorsAndDynamicInterceptionAdvice(Method method, Class<?> targetClass) {
        Integer cacheKey = method.hashCode();
        List<Object> cached = this.methodCache.get(cacheKey);
        if (cached == null) {
            cached = this.advisorChainFactory.getInterceptorsAndDynamicInterceptionAdvice(this, method, targetClass);
            this.methodCache.put(cacheKey, cached);
        }
        return cached;
    }
}
