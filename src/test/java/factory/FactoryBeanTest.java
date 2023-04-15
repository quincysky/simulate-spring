package factory;

import beans.BeansException;
import context.support.ClassPathXmlApplicationContext;
import entity.Car;
import entity.CarFactoryBean;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 15 21:42
 */
public class FactoryBeanTest {
    @Test
    public void testFactoryBean() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:factory-bean.xml");
        Car car = applicationContext.getBean("car", Car.class);
        System.out.println(car.getBrand());
    }
}
