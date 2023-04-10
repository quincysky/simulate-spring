package beans;

/**
 * 属性定义
 * @author quincy
 * @create 2023 - 04 - 10 15:48
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
