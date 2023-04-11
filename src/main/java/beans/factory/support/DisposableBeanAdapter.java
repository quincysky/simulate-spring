package beans.factory.support;

import beans.BeansException;
import beans.DisposableBean;
import beans.factory.config.BeanDefinition;
import cn.hutool.core.util.ClassUtil;
import cn.hutool.core.util.StrUtil;

import java.io.ObjectStreamException;
import java.lang.reflect.Method;

/**
 * @author quincy
 * @create 2023 - 04 - 11 16:48
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 避免同时继承DisposableBean, 且定义方法与DisposableBean方法同名，销毁方法执行两次的情况
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destory".equals(this.destroyMethodName))) {
            //执行自定义方法
            Method destoryMethod = ClassUtil.getPublicMethod(bean.getClass(), destroyMethodName);
            if (destoryMethod == null) {
                throw new BeansException("Couldn't find a destory method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destoryMethod.invoke(bean);
        }
    }
}
