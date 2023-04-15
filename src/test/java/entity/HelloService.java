package entity;

import beans.BeansException;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import context.ApplicationContext;
import context.ApplicationContextAware;

/**
 * @author quincy
 * @create 2023 - 04 - 15 19:23
 */
public class HelloService implements ApplicationContextAware, BeanFactoryAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
