package beans.factory.config;

import beans.BeansException;
import beans.factory.BeanFactory;

/**
 * @author quincy
 * @create 2023 - 04 - 11 15:02
 */
public interface AutowireCapableBeanFactory extends BeanFactory {

    /**
     * 执行BeanProcessor的postProcessBeforeInitialization方法
     *
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

    /**
     * 执行BeanPostProcessors的postProcessAfterInitialization方法
     * @param existingBean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
