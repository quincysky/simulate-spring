package beans.factory;

import beans.BeansException;

import java.util.Map;

/**
 * 它可以枚举所有的bean实例，而不是尝试按客户端请求的名称逐个查找bean
 *
 * @author quincy
 * @create 2023 - 04 - 11 19:47
 */
public interface ListableBeanFactory extends BeanFactory{

    /**
     * 返回指定类型的所有实例
     * @param type
     * @param <T>
     * @return
     * @throws BeansException
     */
    <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException;

    /**
     * 返回定义的所有bean的名称
     * @return
     */
    String[] getBeanDefinitionNames();
}
