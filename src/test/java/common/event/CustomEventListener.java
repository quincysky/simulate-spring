package common.event;

import context.ApplicationListener;

/**
 * @author quincy
 * @create 2023 - 04 - 15 22:02
 */
public class CustomEventListener implements ApplicationListener<CustomEvent> {
    @Override
    public void onApplicationEvent(CustomEvent event) {
        System.out.println(this.getClass().getName());
    }
}
