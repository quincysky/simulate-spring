package ioc;

import bean.AnnotationCar;
import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 19 21:15
 */
public class PackageScanTest {
    @Test
    public void testPackageScan() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:package-scan.xml");
        AnnotationCar car = applicationContext.getBean("annotationCar", AnnotationCar.class);
        assertThat(car).isNotNull();
    }
}
