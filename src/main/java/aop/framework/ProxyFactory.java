package aop.framework;

import aop.AdvisedSupport;

/**
 * @author quincy
 * @create 2023 - 04 - 18 14:25
 */
public class ProxyFactory extends AdvisedSupport {

    public ProxyFactory() {}

    public Object getProxy() {
        return createProxy().getProxy();
    }

    private AopProxy createProxy() {
        if (this.isProxyTargetClass() || this.getTargetSource().getTargetClass().length == 0) {
            return new CglibAopProxy(this);
        }

        return new JdkDynamicAopProxy(this);
    }
}
