package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;

/**
 * bean的实例化策略
 * @author quincy
 * @create 2023 - 04 - 10 20:52
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition) throws BeansException;
}
