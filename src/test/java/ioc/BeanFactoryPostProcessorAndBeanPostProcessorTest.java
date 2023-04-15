package ioc;

import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import common.CustomBeanFactoryPostProcessor;
import common.CustomerBeanPostProcessor;
import core.io.DefaultResourceLoader;
import entity.Car;
import entity.Person;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 13 18:50
 */
public class BeanFactoryPostProcessorAndBeanPostProcessorTest {

    @Test
    public void testBeanFactoryPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, new DefaultResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 在所有BeanDefinition加载完成后，但在bean实例化之前，修改BeanDefinition的属性值
        CustomBeanFactoryPostProcessor beanFactoryPostProcessor = new CustomBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }

    @Test
    public void testBeanPostProcessor() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, new DefaultResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        // 添加bean实例化后的处理器
        CustomerBeanPostProcessor customerBeanPostProcessor = new CustomerBeanPostProcessor();
        beanFactory.addBeanPostProcessor(customerBeanPostProcessor);

        Car car = (Car) beanFactory.getBean("car");
        System.out.println(car);
    }
}
