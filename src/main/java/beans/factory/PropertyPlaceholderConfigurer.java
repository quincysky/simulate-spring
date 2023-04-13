package beans.factory;

import beans.BeansException;
import beans.PropertyValue;
import beans.PropertyValues;
import beans.factory.config.BeanDefinition;
import beans.factory.config.BeanFactoryPostProcessor;
import core.io.DefaultResourceLoader;
import core.io.Resource;
import util.StringValueResolver;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * PropertyPlaceholderConfigurer 的作用是用properties文件的配置值替换xml文件中的占位符
 * @author quincy
 * @create 2023 - 04 - 13 16:46
 */
public class PropertyPlaceholderConfigurer implements BeanFactoryPostProcessor {

    public final String PLACEHOLDER_PREFIX = "${";

    public final String PLACEHOLDER_SUFFIX = "}";

    private String location;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        // 加载属性配置文件
        Properties properties = loadProperties();

        // 属性值替换占位符
        processProperties(beanFactory, properties);

        // 往容器中添加字符解析器，供解析@Value注解使用
        StringValueResolver valueResolver = new PlaceholderResolvingStringValueResolver(properties);
        beanFactory.addEmbeddedValueResolver(valueResolver);

    }

    /**
     * 加载属性配置文件
     *
     * @return
     */
    private Properties loadProperties() {
        try {
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(location);
            Properties properties = new Properties();
            properties.load(resource.getInputStream());
            return properties;
        } catch (IOException e) {
            throw new BeansException("Could not load properties", e);
        }
    }

    private void processProperties(ConfigurableListableBeanFactory beanFactory, Properties properties) throws BeansException {
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();

    }

    /**
     * 解析属性值
     * @param beanDefinition
     * @param properties
     */
    private void resolvePropertyValues(BeanDefinition beanDefinition, Properties properties) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof String) {
                value = resolvePlaceholder((String) value, properties);
                propertyValues.addPropertyValue(new PropertyValue(propertyValue.getName(), value));
            }
        }
    }

    /**
     * 将{XXX}的占位符解析成Properties文件中的具体值
     * @param value
     * @param properties
     * @return
     */
    private String resolvePlaceholder(String value, Properties properties) {
        String strVal = value;
        StringBuffer buf = new StringBuffer(strVal);
        int startIndex = strVal.indexOf(PLACEHOLDER_PREFIX);
        int endIndex = strVal.indexOf(PLACEHOLDER_SUFFIX);
        // 如果是{}的格式说明是占位符，需要解析
        if (startIndex != -1 && endIndex != -1 && startIndex < endIndex) {
            String proKey = strVal.substring(startIndex + 2, endIndex);
            String proValue = properties.getProperty(proKey);
            buf.replace(startIndex, endIndex + 1, proValue);
        }
        return buf.toString();
    }

    private class PlaceholderResolvingStringValueResolver implements StringValueResolver {

        private final Properties properties;

        public PlaceholderResolvingStringValueResolver(Properties properties) {
            this.properties = properties;
        }

        @Override
        public String resolveStringValue(String strVal) {
            return PropertyPlaceholderConfigurer.this.resolvePlaceholder(strVal, properties);
        }
    }
}
