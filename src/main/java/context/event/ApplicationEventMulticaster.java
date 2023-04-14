package context.event;

import context.ApplicationEvent;
import context.ApplicationListener;

/**
 * ApplicationEventMulticaster接口实现类可以管理多个ApplicationListener监听器对象，并且发布事件到监听器
 * ApplicationEventMulticaster其实是ApplicationEventPublisher发布事件的代理类
 * @author quincy
 * @create 2023 - 04 - 14 13:59
 */
public interface ApplicationEventMulticaster {

    void addApplicationListener(ApplicationListener<?> listener);

    void removeApplicationListener(ApplicationListener<?> listener);

    void multicastEvent(ApplicationEvent event);
}
