package context.annotation;

import java.lang.annotation.*;

/**
 * @author quincy
 * @create 2023 - 04 - 19 20:21
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {

    String value() default "singleton";
}
