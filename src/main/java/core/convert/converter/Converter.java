package core.convert.converter;

/**
 * 类型转换接口抽象
 *
 * 类型转换的时机有两个：
 * ①为bean填充属性时，见AbstractAutowireCapableBeanFactory#applyPropertyValues
 * ②处理@Value注解时，见AutowiredAnnotationBeanPostProcessor#postProcessPropertyValues
 * @author quincy
 * @create 2023 - 04 - 20 16:19
 */
public interface Converter<S, T> {

    /**
     * 类型转换
     * @param source
     * @return
     */
    T convert(S source);
}
