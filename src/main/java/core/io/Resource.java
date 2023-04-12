package core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源的抽象和访问接口
 *
 * @author quincy
 * @create 2023 - 04 - 12 20:26
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
