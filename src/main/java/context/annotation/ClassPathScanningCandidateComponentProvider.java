package context.annotation;

import beans.factory.config.BeanDefinition;
import cn.hutool.core.util.ClassUtil;
import stereotype.Component;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author quincy
 * @create 2023 - 04 - 19 19:56
 */
public class ClassPathScanningCandidateComponentProvider {

    /**
     * 获取指定包下的@Componet的类
     * @param basePackage
     * @return
     */
    public Set<BeanDefinition> findCandidateComponents(String basePackage) {
        Set<BeanDefinition> candidates = new LinkedHashSet<BeanDefinition>();
        // 扫描有@Component注解的类，使用hutool包工具
        Set<Class<?>> classes = ClassUtil.scanPackageByAnnotation(basePackage, Component.class);
        for (Class<?> clazz : classes) {
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            candidates.add(beanDefinition);
        }
        return candidates;
    }
}
