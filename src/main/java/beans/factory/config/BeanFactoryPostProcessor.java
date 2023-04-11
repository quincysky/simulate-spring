package beans.factory.config;

/**
 * 允许自定义修改BeanDefinition的属性值。用于在Bean初始化前后插入我们的逻辑(Bean增强、Bean代理等)
 *
 * @author quincy
 * @create 2023 - 04 - 10 19:25
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory();
}
