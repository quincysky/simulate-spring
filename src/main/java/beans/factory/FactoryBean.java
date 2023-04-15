package beans.factory;

/**
 * FactoryBean是一种特殊的Bean,当向容器获取该bean时，容器不是返回其本身，而是返回其Factory#getObject方法的返回值。
 *
 * @author quincy
 * @create 2023 - 04 - 10 20:00
 */
public interface FactoryBean<T> {

    T getObject() throws Exception;

    boolean isSingleton();
}
