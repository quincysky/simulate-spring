package context;

import java.util.EventListener;

/**
 * ApplicationEvent监听器
 * @author quincy
 * @create 2023 - 04 - 13 22:09
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {

    void onApplicationEvent(E event);
}
