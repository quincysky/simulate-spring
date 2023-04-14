package context.support;

import beans.BeansException;

/**
 * xml文件的应用上下文
 * @author quincy
 * @create 2023 - 04 - 14 16:07
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext{

    private String[] configLocations;

    /**
     * 从单个xml文件中加载BeanDefinition, 并自动刷新上下文
     * @param configLocation
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String configLocation) throws BeansException {
        this(new String[]{configLocation});
    }

    /**
     * 从多个xml文件加载BeanDefinition, 并自动刷新上下文
     * @param configLocations xml配置文件位置
     * @throws BeansException
     */
    public ClassPathXmlApplicationContext(String[] configLocations) throws BeansException {
        this.configLocations = configLocations;
        refresh();
    }

    @Override
    protected String[] getConfigLocations() {
        return this.configLocations;
    }
}
