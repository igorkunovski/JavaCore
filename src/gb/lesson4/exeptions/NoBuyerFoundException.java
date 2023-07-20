package gb.lesson4.exeptions;

/**
 * NoBuyerFoundException is thrown out when passed buyer is not in the list of the Shop Buyers
 */

public class NoBuyerFoundException extends OrderException{

    public NoBuyerFoundException() {
    }

    public NoBuyerFoundException(String message) {
        super(message);
    }
}
