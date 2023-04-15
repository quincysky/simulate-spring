package ioc;

import context.support.ClassPathXmlApplicationContext;
import entity.Car;
import entity.Person;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 14 16:15
 */
public class ApplicationContextTest {

    @Test
    public void testApplicationContext() throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
        applicationContext.close();
    }

}
