package beans.factory.config;

import beans.PropertyValues;

import java.util.Objects;

/**
 * BeanDefinition用于bean信息的类，包含bean的class类型、构造参数、属性值等信息。每个bean对应一个BeanDefinition实例。
 * BeanDefinition包含了我们对bean做的配置，比如XML<bean/>标签的形式进行配置
 * 换言之，Spring将我们对bean的定义信息进行了抽象，抽象后的实体就是BeanDefinition,并且Spring会以此作为标准来对Bean进行创建
 * @author quincy
 * @create 2023 - 04 - 10 15:43
 */
public class BeanDefinition {
    public static String SCOPE_SINGLETON = "singleton";
    public static String SCOPE_PROTOTYPE = "prototype";

    private Class beanClass;

    private PropertyValues propertyValues;

    // 针对在xml文件中指定初始化方法
    private String initMethodName;

    // 针对在xml文件中指定销毁方法
    private String destroyMethodName;

    private String scope = SCOPE_SINGLETON;

    private boolean singleton = true;

    private boolean prototype = false;

    private boolean lazyInit = false;

    public BeanDefinition(Class beanClass) {
        this(beanClass, null);
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    /**
     * 设置Bean的作用域，默认单例作用域
     * @param scope
     */
    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope);
        this.prototype = SCOPE_PROTOTYPE.equals(scope);
    }

    public boolean isSingleton() {
        return this.singleton;
    }

    public boolean isPrototype() {
        return this.prototype;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValues() {
        return propertyValues;
    }

    public void setPropertyValues(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public String getInitMethodName() {
        return initMethodName;
    }

    public void setInitMethodName(String initMethodName) {
        this.initMethodName = initMethodName;
    }

    public String getDestroyMethodName() {
        return destroyMethodName;
    }

    public void setDestroyMethodName(String destroyMethodName) {
        this.destroyMethodName = destroyMethodName;
    }

    public boolean isLazyInit() {
        return lazyInit;
    }

    public void setLazyInit(boolean lazyInit) {
        this.lazyInit = lazyInit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(beanClass);
    }

    /**
     * BeanClass相等即为相等
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BeanDefinition cur = (BeanDefinition) obj;
        return beanClass.equals(cur.beanClass);
    }
}
