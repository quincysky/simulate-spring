package beans.factory;

/**
 * 初始化bean
 * @author quincy
 * @create 2023 - 04 - 11 16:35
 */
public interface InitializingBean {

    void afterPropertiesSet() throws Exception;
}
