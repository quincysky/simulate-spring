package beans.factory.config;

import beans.factory.ConfigurableListableBeanFactory;

/**
 * BeanFactoryProcessor是Spring提供的容器扩展机制，允许我们在bean实例化之前修改bena的定义信息即BeanDefinition的信息
 *
 * @author quincy
 * @create 2023 - 04 - 10 19:25
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefinition加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     *
     * @param beanFactory
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);
}
