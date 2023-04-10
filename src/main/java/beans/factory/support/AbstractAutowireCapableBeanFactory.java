package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanFactoryPostProcessor;
import beans.factory.config.BeanPostProcessor;

/**
 * 整体这个类做的事情有：提供bean创建功能(通过构造器)、属性渲染、装配(包括自动装配）、初始化。
 *  处理运行时的bean引用，解析已经管理的结果、调用初始化方法、并且提供了自动装配功能
 * @author quincy
 * @create 2023 - 04 - 10 21:13
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new SimpleInstantiationStrategy();



    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return null;
    }

    @Override
    protected boolean containBeanDefinition(String beanName) {
        return false;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        // 如果bean需要代理，则直接返回代理对象
        return null;

    }

    protected Object resolveBeforeInstantiation(String beanName, BeanDefinition beanDefinition) {
        return null;
    }

    protected Object applyBeanPostProcessorBeforeInstantiation(Class beanClass, String beanName) {
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {

        }
        return null;
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        return null;
    }
}
