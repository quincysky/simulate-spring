package aop;

import org.assertj.core.api.ObjectEnumerableAssert;

/**
 * TargetSource 被代理对象的封装
 * @author quincy
 * @create 2023 - 04 - 16 15:28
 */
public class TargetSource {
    private final Object target;

    public TargetSource(Object target) {
        this.target = target;
    }

    /**
     * 返回目标类实现的接口
     * ?通配符用于表示方法参数或返回值的类型不确定时， 泛型用于创建可重用的类或方法，可以适用于多种类型
     * @return
     */
    public Class<?>[] getTargetClass() {
        return this.target.getClass().getInterfaces();
    }

    public Object getTarget() {
        return this.target;
    }
}
