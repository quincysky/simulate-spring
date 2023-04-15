package beans.factory;

/**
 * 类如果想拥有销毁方法，可以实现该接口
 * @author quincy
 * @create 2023 - 04 - 15 14:17
 */
public interface DisposableBean {

    void destroy() throws Exception;
}
