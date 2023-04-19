package beans.factory.config;

import beans.BeansException;
import beans.PropertyValues;

import java.io.ObjectStreamException;

/**
 * BeanPostProcessor的子类，用于Bean实例化前后的处理。
 * 如果InstantiationAwareBeanPostProcessor处理阶段返回代理对象，会导致短路，不会继续走原来的创建bean的流程
 *
 * Initialization是初始化的意思， Instantiation是实例化的意思
 * 在Bean生命周期中，实例化指的是创建Bean的过程，初始化指的是Bean创建后，对其属性进行赋值，后置处理等操作的过程
 * 实例化执行时机先于初始化时机
 *
 * @author quincy
 * @create 2023 - 04 - 11 14:44
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor{

    /**
     * 在bean实例化之前调用，如果该方法返回是非Null对象，则Spring容器将使用该对象作为bean实例，而不是常见新的bean实例。
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行(也就是初始化之前)
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException;

    /**
     * bean实例化之后，设置属性之前执行
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;

    /**
     * 提前暴露bean
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    default Object getEarlyBeanReference(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
