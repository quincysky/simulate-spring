package common.event;

import context.event.ApplicationContextEvent;

/**
 * @author quincy
 * @create 2023 - 04 - 15 22:01
 */
public class CustomEvent extends ApplicationContextEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public CustomEvent(Object source) {
        super(source);
    }
}
