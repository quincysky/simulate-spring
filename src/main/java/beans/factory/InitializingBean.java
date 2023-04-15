package beans.factory;

/**
 * 一个对象要想拥有初始化方法，可以实现该接口
 * @author quincy
 * @create 2023 - 04 - 11 16:35
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
