package ioc;

import context.support.ClassPathXmlApplicationContext;
import entity.Car;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 15 21:24
 */
public class PrototypeBeanTest {
    @Test
    public void testPrototype() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:prototype-bean.xml");

        Car car1 = applicationContext.getBean("car", Car.class);
        Car car2 = applicationContext.getBean("car", Car.class);
        assertThat(car2 != car1).isTrue();

    }
}
