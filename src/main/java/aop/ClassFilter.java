package aop;

/**
 * 类过滤器
 * @author quincy
 * @create 2023 - 04 - 16 14:28
 */
public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
