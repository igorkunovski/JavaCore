package gb.lesson4;

import java.util.Random;

/**
 *
 * Class Buyer holds data and working methods of order.
 *
 * @param counter - static int of total generated orders
 * @param id - int id of the order, attached to generated order counter
 * @param cost - double total final cost of the order
 * @param qty - int qty of the item
 * @param discount - enum discount for the order
 *
 */

public class Order {

    private static int counter = 0;

    private final int id;
    private final double cost;
    private Buyer buyer;
    private Item item;
    private int qty;
    private int discount;
    private enum Discount{
        DISCOUNT_0, DISCOUNT_5, DISCOUNT_10, DISCOUNT_15, DISCOUNT_20;
    }

    public Order(Buyer buyer, Item item, int qty) {
        this.buyer = buyer;
        this.item = item;
        this.qty = qty;
        this.cost = setCost();

        this.id = ++counter;
    }

    public static int getCounter() {
        return counter;
    }

    public static void reverseCounter() {
        counter--;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getCost() {
        return cost;
    }

    public int getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }


    /**
     *
     * @return - double cost of the order calculated with random discount
     */
    public double setCost() {

        String discount = Discount.values()[new Random().nextInt(Discount.values().length)].name();

        switch (discount) {
            case "DISCOUNT_5" -> {
                this.discount = 5;
                return item.getPrice() * qty * 0.95;
            }
            case "DISCOUNT_10" -> {
                this.discount = 10;
                return item.getPrice() * qty * 0.9;
            }
            case "DISCOUNT_15" -> {
                this.discount = 15;
                return item.getPrice() * qty * 0.85;
            }
            case "DISCOUNT_20" -> {
                this.discount = 20;
                return item.getPrice() * qty * 0.8;
            }
        }
        this.discount = 0;
        return item.getPrice() * qty;
    }

    @Override
    public String toString() {
        return "Order Nr." + getId() + " [[" +
                getBuyer() + " " +
                getItem() +
                " amountItems=" + getQty() +
                ", totalCost=" + getCost() +
                ", discount= " +  getDiscount() + " %" +
                ']';
    }
}
