package beans.factory;

import beans.BeansException;

/**
 * bean容器
 *
 * @author quincy
 * @create 2023 - 04 - 10 15:31
 */
public interface BeanFactory {

    /**
     * 获取Bean
     * @param name
     * @return
     * @throws BeansException
     */
    Object getBean(String name) throws BeansException;


    /**
     * 根据名称和类型查找Bean
     * @param name
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;


    /**
     * 根据类型查找bean
     * @param requiredType
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> T getBean(Class<T> requiredType) throws BeansException;

    boolean containsBean(String name);
}
