package beans.factory.config;

import beans.BeansException;

/**
 * BeanPostProcessor是后置处理器。通过该接口可以自定义调用Bean初始化前后执行的操作方法
 *
 * BeanPostProcessor也是spring提供的容器扩展机制。不同于BeanFactoryPostProcessor的是，BeanPostProcessor在bean实例化后修改bean或替换bean
 *
 * BeanPostProcessor是后面实现AOP的关键。
 *
 * @author quincy
 * @create 2023 - 04 - 10 19:17
 */
public interface BeanPostProcessor {

    /**
     * 在Bean实例化、依赖注入后，初始化前调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在bean实例化、依赖注入，初始化之后调用
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
