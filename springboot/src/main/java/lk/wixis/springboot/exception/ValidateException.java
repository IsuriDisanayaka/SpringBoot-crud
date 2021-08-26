package lk.wixis.springboot.exception;


/**
 * @author : Isuri Disanayaka
 * @date:26/08/2021
 * @since : 0.0.1
 **/
public class ValidateException extends RuntimeException {
    public ValidateException(String message) {
        super(message);
    }
}
