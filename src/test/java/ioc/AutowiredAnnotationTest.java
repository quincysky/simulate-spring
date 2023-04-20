package ioc;

import context.annotation.ClassPathBeanDefinitionScanner;
import context.support.ClassPathXmlApplicationContext;
import entity.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 20 15:30
 */
public class AutowiredAnnotationTest {

    @Test
    public void testAutowiredAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:autowired-annotation.xml");
        Person person = applicationContext.getBean("person", Person.class);
        assertThat(person.getCar()).isNotNull();
    }
}
