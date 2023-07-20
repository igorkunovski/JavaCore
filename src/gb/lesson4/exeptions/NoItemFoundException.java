package gb.lesson4.exeptions;

/**
 * NoItemFoundException is thrown out when Item is not at the Shop stock
 */

public class NoItemFoundException extends OrderException{
    public NoItemFoundException() {
    }

    public NoItemFoundException(String message) {
        super(message);
    }
}
