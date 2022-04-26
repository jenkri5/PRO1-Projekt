package kas.application.model;

public class Utility {

    private final String name;
    private final double price; // per night

    public Utility(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }

}
