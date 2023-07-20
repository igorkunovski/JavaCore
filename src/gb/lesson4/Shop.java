package gb.lesson4;

import gb.lesson4.exeptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


/**
 * Class Shop holds data and working methods of Shop.
 *
 * @param stock - HashMap collection of items at stock
 * @param buyers - HashSet collection of unique buyers of the shop
 * @param orders - ArrayList collection of successful orders
 *
 */

public class Shop {
    private final HashMap<Item, Integer> stock ;
    private final HashSet<Buyer> buyers;
    private final ArrayList<Order> orders;

    public Shop() {
        this.stock = new HashMap<>();
        this.buyers = new HashSet<>();
        this.orders = new ArrayList<>();
    }

    public HashMap<Item, Integer> getStock() {
        return stock;
    }

    public HashSet<Buyer> getBuyers() {
        return buyers;
    }

    public ArrayList<Order> getOrders() {
        return orders;
    }

    /*
    possible to add methods for finding order by id, buyer name, cost, discount etc.
     */

    public void updateStock(Item item, int qty){
        if (!getStock().containsKey(item)){
            stock.put(item, qty);
        }
    }

    public void addBuyer(Buyer buyer) {
        buyers.add(buyer);
    }

    /**
     *
     * @param buyer - Buyer oh the order
     * @param item - Item of the order
     * @param qty - qty of the item of the order
     * @return - method checks required Buyer, Stock, qty, credit amount and successfully generate Order if all ok
     * or throws Order Exception depending on problem otherwise.
     *
     */
    public Order deal(Buyer buyer, Item item, int qty){

        try {

            if (qty <= 0) throw new IllegalAmountException("Amount is: " + qty + "\nExpected > 0");
            if (!buyers.contains(buyer)) throw new NoBuyerFoundException("This buyer is not in the list");
            if (!stock.containsKey(item)) throw new NoItemFoundException("Shop doesn't have " + item);
            if (stock.get(item) - qty < 0)  throw new NotEnoughStockException("Not enough qty at stock");

            Order newOrder = new Order(buyer, item, qty);

            if (buyer.getCredit() < newOrder.getCost())  {
                Order.reverseCounter();
                throw new NotEnoughAccountException("Not enough money at account");
            }

            else {
                buyer.setCredit(buyer.getCredit() - newOrder.getCost());
                stock.put(newOrder.getItem(), stock.get(newOrder.getItem()) - qty);
                orders.add(newOrder);
                return newOrder;
            }
        }catch (OrderException e){
            System.err.println(e.getMessage() + " ID Nr." + buyer.getID() + " Name: " + buyer.getName() +
                    "! Order was not generated!");
        }
        try {
            throw new OrderException("Something went wrong");
        } catch (OrderException ignored) {
            return null;
        }
    }
}
