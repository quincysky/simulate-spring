package context.event;

import beans.BeansException;
import beans.factory.BeanFactory;
import context.ApplicationEvent;
import context.ApplicationListener;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author quincy
 * @create 2023 - 04 - 14 14:47
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster{

    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @Override
    public void multicastEvent(ApplicationEvent event) {
        for (ApplicationListener<ApplicationEvent> applicationListener : applicationListeners) {
            if (supportsEvent(applicationListener, event)) {
                applicationListener.onApplicationEvent(event);
            }
        }

    }

    /**
     * 监听器是否对该事件感兴趣
     *
     * 说一下Class中的getGenericInterfaces()和getInterfaces()
     * getGenericInterfaces()返回实现接口信息的Type数组，包含泛型信息
     * getInterfaces()返回实现接口信息的Class数组，不包含泛型信息
     *
     * ParameterizeType中的getActualTypeArguments()方法简单来说就是获取<>里的类型参数的类型
     *
     * @param applicationListener
     * @param event
     * @return
     */
    protected boolean supportsEvent(ApplicationListener<ApplicationEvent> applicationListener, ApplicationEvent event) {
        // 获取该监听器实现的第一个接口
        Type type = applicationListener.getClass().getGenericInterfaces()[0];

        Type actualTypeArgument = ((ParameterizedType) type).getActualTypeArguments()[0];
        String className = actualTypeArgument.getTypeName();
        Class<?> eventClassName;
        try {
            eventClassName = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new BeansException("wrong event class name: " + className);
        }
        return eventClassName.isAssignableFrom(event.getClass());

    }
}
