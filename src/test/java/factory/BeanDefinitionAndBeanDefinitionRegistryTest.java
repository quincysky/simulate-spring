package factory;

import beans.factory.config.BeanDefinition;
import beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 11 20:36
 */
public class BeanDefinitionAndBeanDefinitionRegistryTest {

    @Test
    public void testBeanDefinition() throws Exception {

        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(HelloService.class);
        beanFactory.registerBeanDefinition("helloService", beanDefinition);

        HelloService helloService = (HelloService)beanFactory.getBean("helloService");
        helloService.sayHello();
    }
}

