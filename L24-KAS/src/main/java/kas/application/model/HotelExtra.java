package kas.application.model;

public class HotelExtra {

    private final String name;
    private final double price; // per night
    private final String description;

    public HotelExtra(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

}
