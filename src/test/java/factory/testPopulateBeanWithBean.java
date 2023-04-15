package factory;

import beans.PropertyValue;
import beans.PropertyValues;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanReference;
import beans.factory.support.DefaultListableBeanFactory;
import entity.Car;
import entity.Person;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 12 20:02
 */
public class testPopulateBeanWithBean {

    @Test
    public void testPopulateBeanWithBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //注册Car实例
        PropertyValues propertyValuesForCar = new PropertyValues();
        propertyValuesForCar.addPropertyValue(new PropertyValue("brand", "porsche"));
        BeanDefinition carBeanDefinition = new BeanDefinition(Car.class, propertyValuesForCar);
        beanFactory.registerBeanDefinition("car", carBeanDefinition);

        //注册Person实例
        PropertyValues propertyValuesForPerson =  new PropertyValues();
        propertyValuesForPerson.addPropertyValue(new PropertyValue("name", "quincy"));
        propertyValuesForPerson.addPropertyValue(new PropertyValue("age", 18));
        // Person实例依赖Car实例
        propertyValuesForPerson.addPropertyValue(new PropertyValue("car", new BeanReference("car")));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValuesForPerson);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        Car car = (Car) beanFactory.getBean("car");
        System.out.println("isEquals ?" + (person.getCar() == car));
    }

}
