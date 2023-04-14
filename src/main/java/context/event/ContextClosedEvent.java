package context.event;

import context.ApplicationEvent;

/**
 * 容器关闭事件
 * @author quincy
 * @create 2023 - 04 - 14 15:39
 */
public class ContextClosedEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ContextClosedEvent(Object source) {
        super(source);
    }
}
