package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;
import core.io.Resource;
import core.io.ResourceLoader;

/**
 * 读取bean定义信息即BeanDefinition的接口
 *
 * @author quincy
 * @create 2023 - 04 - 11 19:26
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinition(String[] locations) throws BeansException;

}
