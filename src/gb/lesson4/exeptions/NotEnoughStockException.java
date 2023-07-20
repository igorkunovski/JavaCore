package gb.lesson4.exeptions;

/**
 * NotEnoughStockException is thrown out when qty at Shop stock smaller than the ordered qty
 */
public class NotEnoughStockException extends OrderException{
    public NotEnoughStockException() {
    }

    public NotEnoughStockException(String message) {
        super(message);
    }
}
