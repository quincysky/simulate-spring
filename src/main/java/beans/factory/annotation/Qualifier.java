package beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @Qualifier注解用于解决依赖注入时的歧义性问题。
 * 当容器中存在多个同一个类型的bean时，Spring无法确定应该注入哪一个Bean，此时可以使用@Qualifier注解来指定具体的Bean名称
 * @author quincy
 * @create 2023 - 04 - 20 15:14
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
// @Inherited的作用就是标注一个注解是否具有继承性。举例说明就是一个类添加了@Inherited注解的注解，那继承该类的子类也会继承该注解
@Inherited
@Documented
public @interface Qualifier {
    String value() default "";
}
