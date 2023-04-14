package context;

/**
 * 事件发布者接口
 * @author quincy
 * @create 2023 - 04 - 13 21:54
 */
public interface ApplicationEventPublisher {


    /**
     * 发布事件
     *
     * @param event
     */
    void publishEvent(ApplicationEvent event);
}
