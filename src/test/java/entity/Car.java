package entity;

import beans.factory.DisposableBean;
import lombok.Data;
import stereotype.Component;

/**
 * @author quincy
 * @create 2023 - 04 - 12 20:06
 */
@Data
@Component
public class Car {
    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
