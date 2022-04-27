package kas.application.model;

import java.util.ArrayList;

public class Hotel {

    private final String name;
    private final double price; // per night
    private final double priceTwo; // per night
    private final ArrayList<Utility> utilities = new ArrayList<>(); // composition 1 --> 0..* Utility

    /** Pre: name not empty, price >= 0.0, priceTwo >= 0.0. */
    public Hotel(String name, double price, double priceTwo) {
        this.name = name;
        this.price = price;
        this.priceTwo = priceTwo;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceTwo() {
        return priceTwo;
    }

    public ArrayList<Utility> getUtilities() {
        return new ArrayList<>(utilities);
    }

    /** Pre: name not empty, price >= 0.0. */
    public Utility createUtility(String name, double price) {
        Utility utility = new Utility(name, price);
        utilities.add(utility);
        return utility;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

}
