package beans.factory.support;

import beans.BeansException;
import beans.factory.DisposableBean;
import beans.factory.ObjectFactory;
import beans.factory.config.SingletonBeanRegistry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 默认单例Bean注册实现
 * @author quincy
 * @create 2023 - 04 - 10 16:51
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    // 一级缓存 存储的是所有创建好了的单例Bean
    private Map<String, Object> singletonObjects = new HashMap<>();

    // 二级缓存 完成实例化，但是还没进行属性注入及初始化的对象
    private Map<String, Object> earlySingletonObjects = new HashMap<>();

    // 三级缓存 提前暴露的一个单例工厂，二级缓存中存储的就是从这个工厂中获得到的对象
    private Map<String, ObjectFactory<?>> singletonFactories = new HashMap<String, ObjectFactory<?>>();

    private final Map<String, DisposableBean> disposableBeans = new HashMap<>();

    /**
     * 此处简化步骤。在第一次bean创建时，哪个缓存必然时没有的，会使用单例工厂创建然后将单例放入二级缓存。
     * @return
     */
    @Override
    public Object getSingleton(String beanName) {
        Object singletonObject = singletonObjects.get(beanName);
        if (singletonObject == null) {
            singletonObject = earlySingletonObjects.get(beanName);
            if (singletonObject == null) {
                ObjectFactory<?> singletonFactory = this.singletonFactories.get(beanName);
                if (singletonFactory != null) {
                    singletonObject = singletonFactory.getObject();
                    // 从三级缓存放进二级缓存
                    earlySingletonObjects.put(beanName, singletonObject);
                    singletonFactories.remove(beanName);
                }
            }
        }
        return singletonObject;
    }

    @Override
    public void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
        earlySingletonObjects.remove(beanName);
        singletonFactories.remove(beanName);
    }

    protected void addSingletonFactory(String beanName, ObjectFactory<?> singletonFactory) {
        singletonFactories.put(beanName, singletonFactory);
    }

    public void registerDisposableBean(String beanName, DisposableBean bean) {
        disposableBeans.put(beanName, bean);
    }

    public void destroySingletons() {
        ArrayList<String> beanNames = new ArrayList<>(disposableBeans.keySet());
        for (String beanName : beanNames) {
            DisposableBean disposableBean = disposableBeans.remove(beanName);
            try {
                disposableBean.destroy();
            } catch (Exception e) {
                throw new BeansException("Destroy method on bean with name '" + beanName + "' threw an exception", e);
            }
        }
    }
}
