package beans.factory.support;

import beans.BeansException;
import core.io.DefaultResourceLoader;
import core.io.ResourceLoader;

/**
 * 读取bean定义信息的接口的抽象类
 *
 * @author quincy
 * @create 2023 - 04 - 13 14:30
 */
public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(BeanDefinitionRegistry registry) {
        this(registry, new DefaultResourceLoader());
    }

    /**
     * 抽象类不能实例化，按理来说在抽象类中下写构造方法是没有用的，但是抽象类的子类在被继承的时候必须实现抽象类中的一个构造方法
     * @param registry
     * @param resourceLoader
     */
    public AbstractBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    @Override
    public void loadBeanDefinition(String[] locations) throws BeansException {
        for (String location : locations)
            loadBeanDefinitions(location);
    }
}
