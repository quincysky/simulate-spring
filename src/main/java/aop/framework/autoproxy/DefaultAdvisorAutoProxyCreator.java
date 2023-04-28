package aop.framework.autoproxy;

import aop.Advisor;
import aop.ClassFilter;
import aop.Pointcut;
import aop.TargetSource;
import aop.aspectj.AspectJExpressionPointcut;
import aop.aspectj.AspectJExpressionPointcutAdvisor;
import aop.framework.ProxyFactory;
import beans.BeansException;
import beans.PropertyValues;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import beans.factory.config.InstantiationAwareBeanPostProcessor;
import beans.factory.support.DefaultListableBeanFactory;
import org.aopalliance.aop.Advice;
import org.assertj.core.api.ObjectEnumerableAssert;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author quincy
 * @create 2023 - 04 - 18 17:53
 */
public class DefaultAdvisorAutoProxyCreator implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    private Set<Object> earlyProxyReferences = new HashSet<>();

    /**
     * 如果代理工厂中的advisor非空则返回代理类，并将与该对象相匹配的advisor加入到代理中
     * 否则还是返回对象本身。
     * @param bean
     * @param beanName
     * @return
     */
    protected Object warpIfNecessary(Object bean, String beanName) {
        // 避免死循环
        if (isInfrastructureClass(bean.getClass())) {
            return bean;
        }

        Collection<AspectJExpressionPointcutAdvisor> advisors = beanFactory.getBeanOfType(AspectJExpressionPointcutAdvisor.class).values();

        try {
            ProxyFactory proxyFactory = new ProxyFactory();
            for (AspectJExpressionPointcutAdvisor advisor : advisors) {
                ClassFilter classFilter = advisor.getPointcut().getClassFilter();
                if (classFilter.matches(bean.getClass())) {
                    TargetSource targetSource = new TargetSource(bean);
                    proxyFactory.setTargetSource(targetSource);
                    proxyFactory.addAdvisor(advisor);
                    proxyFactory.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
                }
            }

            if (!proxyFactory.getAdvisors().isEmpty()) {
                return proxyFactory.getProxy();
            }
        } catch (Exception ex) {
            throw new BeansException("Error create proxy bean for: " + beanName, ex);
        }
        return bean;
    }

    private boolean isInfrastructureClass(Class<?> beanClass) {
        return Advice.class.isAssignableFrom(beanClass) || Pointcut.class.isAssignableFrom(beanClass) || Advisor.class.isAssignableFrom(beanClass);
    }

    @Override
    public Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        earlyProxyReferences.add(beanName);
        return warpIfNecessary(bean, beanName);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (!earlyProxyReferences.contains(beanName))
            return warpIfNecessary(bean, beanName);

        return bean;
    }

    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        return pvs;
    }
}
