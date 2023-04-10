package beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author quincy
 * @create 2023 - 04 - 10 15:53
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    /**
     * 添加属性值，如果碰到重复属性值覆盖掉原来的属性值。
     * @param pv
     */
    public void addPropertyValue(PropertyValue pv) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue curPro = propertyValueList.get(i);
            if (curPro.getName().equals(pv.getName())) {
                propertyValueList.set(i, pv);
                return;
            }
        }
        propertyValueList.add(pv);
    }

    /**
     * 将List集合转换成数组
     * @return
     */
    public PropertyValue[] getPropertyValues() {
        return propertyValueList.toArray(new PropertyValue[0]);
    }


    /**
     * 根据属性名获得属性值
     * @param propertyByName
     * @return 不包含时返回null
     */
    public PropertyValue getPropertyValue(String propertyByName) {
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue pro = propertyValueList.get(i);
            if(pro.getName().equals(propertyByName))
                return pro;
        }
        return null;
    }
}
