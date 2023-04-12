package factory;

import beans.PropertyValue;
import beans.PropertyValues;
import beans.factory.config.BeanDefinition;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 12 19:24
 */
public class testPopulateBeanWithPropertyValues {

    @Test
    public void testPopulateBeanWithPropertyValues()  {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        Person per =  (Person) beanFactory.getBean("person");
        System.out.println(person);
    }
}
