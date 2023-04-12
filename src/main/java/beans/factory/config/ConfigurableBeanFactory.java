package beans.factory.config;

import beans.factory.HierarchicalBeanFactory;
import core.convert.ConversionService;
import util.StringValueResolver;

/**
 * @author quincy
 * @create 2023 - 04 - 10 19:26
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory, SingletonBeanRegistry {

    /**
     * @param beanPostProcessor
     */
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例Bean
     */
    void destroySingletons();

    void addEmbeddedValueResolver(StringValueResolver valueResolver);

    String resolveEmbeddedValue(String value);

    void setConversionService(ConversionService conversionService);

    ConversionService getConversionService();



}
