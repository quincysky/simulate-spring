package beans.factory.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 注解@Value通过BeanPostProcessor处理。 InstantiationAwareBeanPostProcessor增加postProcessPropertyValues方法。
 * 在bean实例化之后设置属性之前执行。
 * 作用于成员域，方法，构造函数
 * @author quincy
 * @create 2023 - 04 - 19 21:24
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
public @interface Value {

    String value();
}
