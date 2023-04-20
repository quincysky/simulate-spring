package core.convert;

/**
 * 类型转换工厂
 * @author quincy
 * @create 2023 - 04 - 20 16:20
 */
public interface ConverterFactory<S, R> {

    <T extends R> Converter<S, T> getConverter(Class<T> targetType);
}
