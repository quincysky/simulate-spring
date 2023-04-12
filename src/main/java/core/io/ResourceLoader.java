package core.io;

/**
 * 资源加载器接口
 *
 * @author quincy
 * @create 2023 - 04 - 12 21:15
 */
public interface ResourceLoader {

    Resource getResource(String location);
}
