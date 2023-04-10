package beans.factory.support;

import beans.BeansException;
import beans.factory.config.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author quincy
 * @create 2023 - 04 - 10 21:06
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    /**
     * 使用CGLIB动态生成子类
     * @param beanDefinition
     * @return
     * @throws BeansException
     */
    @Override
    public Object instantiate(BeanDefinition beanDefinition) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback((MethodInterceptor)(obj, method, args,proxy) -> proxy.invokeSuper(obj, args));
        return enhancer.create();
    }
}
