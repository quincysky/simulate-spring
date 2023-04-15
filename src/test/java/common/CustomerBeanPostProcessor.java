package common;

import beans.BeansException;
import beans.factory.config.BeanPostProcessor;
import entity.Car;

/**
 * @author quincy
 * @create 2023 - 04 - 13 21:00
 */
public class CustomerBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessBeforeInitialization, beanName" + beanName);
        // 该换名称
        if ("car".equals(beanName)) {
            ((Car) bean).setBrand("lamborghini");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("CustomerBeanPostProcessor#postProcessAfterInitialization, beanName" + beanName);
        return bean;
    }
}
