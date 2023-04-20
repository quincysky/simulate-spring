package entity;

import beans.factory.DisposableBean;
import beans.factory.InitializingBean;
import beans.factory.annotation.Autowired;
import lombok.Data;
import stereotype.Component;

/**
 * @author quincy
 * @create 2023 - 04 - 12 19:21
 */
@Data
@Component
public class Person implements InitializingBean, DisposableBean {

    private String name;
    private  int age;

    @Autowired
    private Car car;

    public void customInit() {
        System.out.println("This is the customInit method");
    }

    public void customDestroy() {
        System.out.println("This is the customDestroy method");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("This is the destroy method");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("This is the afterPropertiesSet method");
    }
}
