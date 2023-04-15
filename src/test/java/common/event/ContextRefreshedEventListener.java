package common.event;

import context.ApplicationListener;
import context.event.ContextClosedEvent;

/**
 * @author quincy
 * @create 2023 - 04 - 15 22:05
 */
public class ContextRefreshedEventListener implements ApplicationListener<ContextClosedEvent> {
    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println(this.getClass().getName());
    }
}
