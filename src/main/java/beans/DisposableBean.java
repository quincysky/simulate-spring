package beans;

/**
 * @author quincy
 * @create 2023 - 04 - 10 18:28
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
