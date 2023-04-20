package core.convert.converter;

/**
 * 类型转换器注册接口
 * @author quincy
 * @create 2023 - 04 - 20 16:35
 */
public interface ConverterRegistry {

    void addConverter(Converter<?, ?> converter);

    void addConverterFactory(ConverterFactory<?, ?> converterFactory);

    void addConverter(GenericConverter converter);
}
