/*
    Simple Shop logic exercise
 */

package gb.lesson4;

/**
 * Class Main holds entry point method of the program
 */

public class Main {
    public static void main(String[] args) {

        Buyer igor = new Buyer("  Igor  ", 100);
        Buyer ivan = new Buyer("  Ivan   ", 50);
        Buyer lena = new Buyer("  Elena   ", 150);
        Item milk = new Item("Milk", 2, Item.Type.DRINK);
        Item bread = new Item("Bread", 10, Item.Type.FOOD);
        Item towel = new Item("Towel", 100, Item.Type.HOUSEHOLD);

        Shop shop1 = new Shop();

        shop1.updateStock(milk, 10);
        shop1.updateStock(bread, 20);
        shop1.updateStock(towel, 5);

        shop1.addBuyer(igor);
        shop1.addBuyer(ivan);

        System.out.println(igor.getCredit());
        System.out.println(shop1.getStock().get(milk));

        Order order1 = shop1.deal(igor, milk, 5);
        System.out.println(order1);

        System.out.println(shop1.getOrders());

        System.out.println(igor.getCredit());
        System.out.println(shop1.getStock().get(milk));
        System.out.println(shop1.getStock().get(bread));

        shop1.deal(igor, bread, 2);

        System.out.println(shop1.getOrders());

        System.out.println(igor.getCredit());
        System.out.println(shop1.getStock().get(milk));
        System.out.println(shop1.getStock().get(bread));

        shop1.deal(ivan, towel, 1);
//        shop1.deal(ivan, towel, -1);
//        shop1.deal(petr, towel, 1);

        System.out.println(ivan.getCredit());
        System.out.println(shop1.getStock().get(towel));

//        Order order6 = shop1.deal(ivan, towel, 1);
        System.out.println("Total successful orders: " + Order.getCounter());
        System.out.println("Total generated buyers: " + Buyer.getTotalBuyers());
        System.out.println("Total shop buyers: " + shop1.getBuyers().size());
        System.out.println("Lena ID is: " +lena.getID());
        System.out.println("---EXIT---");
    }
}
