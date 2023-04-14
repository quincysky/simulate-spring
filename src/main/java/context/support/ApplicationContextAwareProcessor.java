package context.support;

import beans.BeansException;
import beans.factory.config.BeanPostProcessor;
import context.ApplicationContext;
import context.ApplicationContextAware;

/**
 * 能够感知ApplicationContext的后置器
 * @author quincy
 * @create 2023 - 04 - 14 14:15
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    /**
     * 如果该bean实现类ApplicationContextAware接口。在初始化之前设置
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
