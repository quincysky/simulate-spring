package xml;

import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;
import core.io.DefaultResourceLoader;
import factory.Person;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 13 15:57
 */
public class XmlFileDefineBeanTest {

    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, new DefaultResourceLoader());
        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
    }
}
