package gb.lesson4;

import java.util.Objects;

/**
 * Class Buyer holds data and working methods of buyer.
 *
 * @param name - String name of the buyer
 * @param credit - double credit of the buyer
 * @param ID - int unique ID of the buyer, attached to totalBuyers
 * @param totalBuyers - int total generated buyers
 *
 */

public class Buyer {

    private static int totalBuyers = 0;
    private final int ID;
    private String name;
    private double credit;


    public Buyer(String name, double credit) {
        this.name = name.toUpperCase().trim();
        this.credit = credit;
        this.ID = ++totalBuyers;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public static int getTotalBuyers(){
        return totalBuyers;
    }


    // comparing by buyer ID and name

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyer buyer = (Buyer) o;
        return ID == buyer.ID && Objects.equals(name, buyer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name);
    }

    @Override
    public String toString() {
        return "Buyer: " +
                "ID:" + getID()  +
                ", NAME:'" + getName() +
                ", CREDIT:" + getCredit();
    }
}
