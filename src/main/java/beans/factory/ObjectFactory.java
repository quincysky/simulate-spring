package beans.factory;

import beans.BeansException;

/**
 * @author quincy
 * @create 2023 - 04 - 10 18:36
 */
public interface ObjectFactory<T> {
    T getObject() throws BeansException;
}
