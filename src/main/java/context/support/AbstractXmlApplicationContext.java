package context.support;

import beans.BeansException;
import beans.factory.support.DefaultListableBeanFactory;
import beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author quincy
 * @create 2023 - 04 - 14 15:57
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext{

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null)
            beanDefinitionReader.loadBeanDefinition(configLocations);

    }

    protected abstract String[] getConfigLocations();
}
