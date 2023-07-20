package gb.lesson4.exeptions;

/**
 * NotEnoughAccountException is thrown out when buyer credit is smaller than the order cost
 */

public class NotEnoughAccountException extends OrderException{
    public NotEnoughAccountException() {
    }

    public NotEnoughAccountException(String message) {
        super(message);
    }
}
