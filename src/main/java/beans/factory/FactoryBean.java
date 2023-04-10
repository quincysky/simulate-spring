package beans.factory;

/**
 * @author quincy
 * @create 2023 - 04 - 10 20:00
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    boolean isSingleton();
}
