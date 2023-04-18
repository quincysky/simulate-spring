package aop;

import context.support.ClassPathXmlApplicationContext;
import org.junit.Test;
import service.WorldService;

/**
 * @author quincy
 * @create 2023 - 04 - 18 18:20
 */
public class AutoProxyTest {

    @Test
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

        // 获取代理对象
        WorldService worldService = applicationContext.getBean("worldService", WorldService.class);
        worldService.explode();
    }
}
