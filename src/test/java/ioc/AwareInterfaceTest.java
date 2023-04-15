package ioc;

import context.support.ClassPathXmlApplicationContext;
import entity.HelloService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 15 19:26
 */
public class AwareInterfaceTest {

    @Test
    public void testAware() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        HelloService helloService = applicationContext.getBean("helloService", HelloService.class);
        assertThat(helloService.getBeanFactory()).isNotNull();
        assertThat(helloService.getApplicationContext()).isNotNull();
    }
}
