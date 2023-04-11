package beans.factory.support;

import beans.BeansException;
import beans.factory.ConfigurableListableBeanFactory;
import beans.factory.config.BeanDefinition;
import beans.factory.config.ConfigurableBeanFactory;

import java.util.*;

/**
 * @author quincy
 * @create 2023 - 04 - 11 19:30
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory
        implements ConfigurableListableBeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();


    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        List<String> beanNames = new ArrayList<>();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            Class beanClass = entry.getValue().getBeanClass();
            // 判断两个类是否相等或者是父子类关系
            if (requiredType.isAssignableFrom(beanClass)) {
                beanNames.add(entry.getKey());
            }
        }
        if (beanNames.size() == 1) return getBean(beanNames.get(0), requiredType);

        throw new BeansException(requiredType + "expected single bean but found " + beanNames.size() + ": " + beanNames);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public void registerBeanDefinition(String name, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(name, beanDefinition);
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (beanDefinition == null) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
    }


    @Override
    public void preInstantiateSingletons() throws BeansException {
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            // 只有当bean是单例且不为懒加载才会被创建
            if (beanDefinition.isSingleton() && !beanDefinition.isSingleton()) {
                getBean(beanName);
            }
        });

    }

    @Override
    public <T> Map<String, T> getBeanOfType(Class<T> type) throws BeansException {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                T bean = (T) getBean(beanName);
                result.put(beanName, bean);
            }
        });
        return result;
    }

    @Override
    public String[] getBeanDefinitionNames() {
        Set<String> beanNames = beanDefinitionMap.keySet();
        return beanNames.toArray(new String[beanNames.size()]);
    }
}
