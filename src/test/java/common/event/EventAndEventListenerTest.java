package common.event;

import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author quincy
 * @create 2023 - 04 - 15 22:10
 */
public class EventAndEventListenerTest {

    @Test
    public void testEventListener() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:event-and-event-listener.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext));

        applicationContext.registerShutdownHook();

    }
}
