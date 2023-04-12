package core.convert;

/**
 * 如果要将一种Object类型转换成另一种Object类型只能使用ConversionService
 * JDK提供的PropertyEditor只能将String类型转换为Object
 * @author quincy
 * @create 2023 - 04 - 10 19:35
 */
public interface ConversionService {

    /**
     * 判断源类型和目标类型是否可以转换
     * @param sourceType
     * @param targetType
     * @return
     */
    boolean canConvert(Class<?> sourceType, Class<?> targetType);

    /**
     * 转换API
     * @param source
     * @param targetType
     * @param <T>
     * @return
     */
    <T> T convert(Object source, Class<T> targetType);
}
