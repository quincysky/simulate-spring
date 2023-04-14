package context.event;

import beans.BeansException;
import beans.factory.BeanFactory;
import beans.factory.BeanFactoryAware;
import context.ApplicationEvent;
import context.ApplicationListener;

import java.util.HashSet;
import java.util.Set;

/**
 * @author quincy
 * @create 2023 - 04 - 14 14:40
 */
public abstract class AbstractApplicationEventMulticaster implements ApplicationEventMulticaster, BeanFactoryAware {

    public final Set<ApplicationListener<ApplicationEvent>> applicationListeners = new HashSet<>();

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void addApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.add((ApplicationListener<ApplicationEvent>) listener);
    }

    @Override
    public void removeApplicationListener(ApplicationListener<?> listener) {
        applicationListeners.remove(listener);
    }
}
