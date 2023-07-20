package gb.lesson4;

/**
 * Class Item holds data and working methods of item.
 *
 * @param name - String name of the item
 * @param price - int price of the item
 * @param Type - Enum type of group where item belongs to
 *
 */

public class Item {

    private String name;
    private int price;
    private Type type;

    public Item(String name, int price, Type type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public enum Type{
        FOOD, DRINK, HOUSEHOLD;
    }

    @Override
    public String toString() {
        return "Item [" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                "],";
    }
}
