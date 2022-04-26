package kas.application.model;

import java.util.ArrayList;

public class Hotel {

    private final String name;
    private final String address;
    private final String city;
    private final String country;
    private final double price; // per night
    private final double priceTwo; // per night
    private final ArrayList<HotelExtra> extras = new ArrayList<>(); // nullable

    public Hotel(String name, String address, String city, String country, double price, double priceTwo) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.price = price;
        this.priceTwo = priceTwo;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public double getPrice() {
        return price;
    }

    public double getPriceTwo() {
        return priceTwo;
    }

    public ArrayList<HotelExtra> getExtras() {
        return extras;
    }

    public void createExtra(String name, double price, String description) {
        HotelExtra extra = new HotelExtra(name, price, description);
        extras.add(extra);
    }
}
