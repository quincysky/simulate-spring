package beans.factory.config;

/**
 * 允许自定义修改BeanDefinition的属性值
 *
 * @author quincy
 * @create 2023 - 04 - 10 19:25
 */
public interface BeanFactoryPostProcessor {
    void postProcessBeanFactory()
}
