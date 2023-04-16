package aop.aspect;

import aop.aspectj.AspectJExpressionPointcut;
import factory.HelloService;
import org.junit.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author quincy
 * @create 2023 - 04 - 16 15:10
 */
public class PointcutExpressionTest {
    @Test
    public void testPointcutExpression() throws Exception {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut("execution(* factory.HelloService.*(..))");
        Class<HelloService> clazz = HelloService.class;
        Method method = clazz.getDeclaredMethod("sayHello");

        assertThat(pointcut.matches(clazz)).isTrue();
        assertThat(pointcut.matches(method, clazz)).isTrue();
    }
}
