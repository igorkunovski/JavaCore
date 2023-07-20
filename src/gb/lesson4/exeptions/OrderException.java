package gb.lesson4.exeptions;

/**
 * Root of the Order creation Exception
 *
 */

public class OrderException extends Exception{
    public OrderException() {
    }

    public OrderException(String message) {
        super(message);
    }
}
