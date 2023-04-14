package context;

import beans.factory.HierarchicalBeanFactory;
import beans.factory.ListableBeanFactory;
import core.io.ResourceLoader;

/**
 * @author quincy
 * @create 2023 - 04 - 13 22:07
 */
public interface ApplicationContext extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {
}
