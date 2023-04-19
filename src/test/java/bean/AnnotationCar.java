package bean;

import beans.factory.annotation.Value;
import lombok.Data;
import stereotype.Component;

/**
 * @author quincy
 * @create 2023 - 04 - 19 20:53
 */
@Component
@Data
public class AnnotationCar {

    @Value("${brand}")
    private String brand;
}
