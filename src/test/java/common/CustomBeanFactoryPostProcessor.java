package common;

import beans.PropertyValue;
import beans.PropertyValues;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanFactoryPostProcessor;

/**
 * 自定义的BeanFactoryPostProcessor
 * @author quincy
 * @create 2023 - 04 - 13 18:45
 */
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        System.out.println("CustomBeanFactoryPostProcessor#postProcessBeanFactory");
        BeanDefinition personBeanDefinition = beanFactory.getBeanDefinition("person");
        PropertyValues propertyValues = personBeanDefinition.getPropertyValues();
        // 将person的name的属性改为test
        propertyValues.addPropertyValue(new PropertyValue("name", "test"));
    }
}
