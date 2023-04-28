package core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * classpath下的资源
 *
 * path不以'/'开头时，则默认是从类路径的包下取资源
 * 如果以'/'开头则是从ClassPath根下获取。
 *
 * @author quincy
 * @create 2023 - 04 - 12 20:40
 */
public class ClassPathResource implements Resource{

    private final String path;

    public ClassPathResource(String path) {
        this.path = path;
    }

    /**
     * getResourceAsStream这个函数寻找文件的起点是JAVA项目编译之后的根目录
     * 比如一般maven项目编译之后根目录都是target/classes这个文件
     * @return
     * @throws IOException
     */
    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.path);
        if (is == null) {
            throw new FileNotFoundException(this.path + " cannot be opened because it does not exist");
        }
        return is;
    }
}
