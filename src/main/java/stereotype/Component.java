package stereotype;

import java.lang.annotation.*;

/**
 * @Target注解是一个元注解，可以应用于一个注解，以限制该注解可以应用在哪些项上。一条没有@Target限制的注解可以应用到任何项上。
 * @Retention元注解指定一条注解应该保留多长时间
 * @Documented元注解为像javadoc这样的归档工具提供了一些提示。应该像处理其他修饰符一样来处理归档注解，以实现归档目的
 * @author quincy
 * @create 2023 - 04 - 19 19:14
 */

@Target(ElementType.TYPE) // TYPE限制应用到类及接口上。
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Component {

    String value() default "";
}
