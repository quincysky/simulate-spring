package beans.factory;

import beans.BeansException;
import beans.factory.config.AutowireCapableBeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanPostProcessor;
import beans.factory.config.ConfigurableBeanFactory;

/**
 * @author quincy
 * @create 2023 - 04 - 11 20:03
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据名称查找BeanDefinition
     * @param beanName
     * @return
     * @throws BeansException
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 提前实例化所有单例实例
     * @throws BeansException
     */
    void preInstantiateSingletons() throws BeansException;

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
