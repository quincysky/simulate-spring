package context;

import beans.BeansException;

/**
 * @author quincy
 * @create 2023 - 04 - 14 13:13
 */
public interface ConfigurableApplicationContext extends ApplicationContext{

    /**
     * 刷新容器
     * 加载或刷新配置的持久表示形式
     * 这是一个启动方法，如果失败了，他应该销毁样创的单例，换句话说就是调用该方法之后，应该实例化所有单例或根本不实例化
     * @throws BeansException
     */
    void refresh() throws BeansException;

    /**
     * 关闭此应用上下文，释放实现可能持有的所有资源或锁
     * 这包括销毁所有缓存的单例bean
     *
     */
    void close();

    /**
     * 向虚拟机中注册一个钩子方法，在虚拟机关闭之前执行关闭容器等操作。
     */
    void registerShutdownHook();
}
