package beans;

/**
 * @author quincy
 * @create 2023 - 04 - 10 15:28
 */
public class BeansException extends RuntimeException{
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
