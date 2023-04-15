package entity;

import beans.factory.DisposableBean;
import lombok.Data;

/**
 * @author quincy
 * @create 2023 - 04 - 12 20:06
 */
@Data
public class Car {
    private String brand;


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

}
