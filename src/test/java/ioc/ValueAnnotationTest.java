package ioc;

import bean.AnnotationCar;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 19 21:51
 */
public class ValueAnnotationTest {

    @Test
    public void testValueAnnotation() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:value-annotation.xml");
        AnnotationCar annotationCar = applicationContext.getBean("annotationCar", AnnotationCar.class);
        System.out.println(annotationCar.getBrand());
    }
}
