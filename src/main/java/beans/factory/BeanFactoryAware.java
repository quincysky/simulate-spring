package beans.factory;

import beans.BeansException;

/**
 *
 * 实现该接口。能感知所属BeanFactory
 *
 * @author quincy
 * @create 2023 - 04 - 11 16:29
 */
public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
