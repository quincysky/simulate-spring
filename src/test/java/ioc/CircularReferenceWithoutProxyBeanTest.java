package ioc;

import context.support.ClassPathXmlApplicationContext;
import entity.A;
import entity.B;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 20 19:27
 */
public class CircularReferenceWithoutProxyBeanTest {

    @Test
    public void testCircularReferenceWithoutProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:circular-without-proxy.xml");
        A a = applicationContext.getBean("a", A.class);
        B b = applicationContext.getBean("b", B.class);
        assertThat(a.getB() == b).isTrue();
    }
}
