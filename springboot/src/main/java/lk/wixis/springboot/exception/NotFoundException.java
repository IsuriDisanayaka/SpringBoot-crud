package lk.wixis.springboot.exception;

/**
 * @author : Isuri Disanayaka
 * @date:26/08/2021
 * @since : 0.0.1
 **/
public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}

