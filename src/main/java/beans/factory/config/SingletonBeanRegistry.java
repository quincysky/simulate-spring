package beans.factory.config;

/**
 * 单例注册表
 * @author quincy
 * @create 2023 - 04 - 10 16:42
 */
public interface SingletonBeanRegistry {
    Object getSingleton(String beanName);

    void addSingleton(String beanName, Object singletonObject);

}
