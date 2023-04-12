package core.io;

import cn.hutool.core.io.IoUtil;
import org.junit.Test;

import java.io.InputStream;

/**
 * @author quincy
 * @create 2023 - 04 - 12 21:25
 */
public class ResoruceAndResourceLoaderTest {
    @Test
    public void testResourceLoader() throws Exception {
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

        // 加载classPath下的资源
        Resource resource = resourceLoader.getResource("classpath:hello.txt");
        InputStream inputStream = resource.getInputStream();
        String content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

        //加载文件系统资源
        resource = resourceLoader.getResource("hello.txt");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);
        assert (content.equals("Hello, 世界！"));

        // 加载url资源
        resource = resourceLoader.getResource("https://www.baidu.com");
        inputStream = resource.getInputStream();
        content = IoUtil.readUtf8(inputStream);
        System.out.println(content);

    }
}
