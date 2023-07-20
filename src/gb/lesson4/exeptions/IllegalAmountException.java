package gb.lesson4.exeptions;

/**
 * IllegalAmountException is thrown out when qty of the order is negative or zero
 */
public class IllegalAmountException extends OrderException {
    public IllegalAmountException() {
    }

    public IllegalAmountException(String message) {
        super(message);
    }
}
