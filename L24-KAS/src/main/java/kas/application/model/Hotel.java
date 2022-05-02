package kas.application.model;

import java.util.ArrayList;

public class Hotel {

    private final String name;
    private final double price; // per night
    private final double priceTwo; // per night
    private final ArrayList<Utility> utilities = new ArrayList<>(); // composition 1 --> 0..* Utility
    final ArrayList<Registration> registrations = new ArrayList<>(); // association 0..* --> 0..* Registration
    final ArrayList<Conference> conferences = new ArrayList<>(); // association 0..* --> 0..* Conference

    /**
     * Pre: name not empty, price >= 0.0, priceTwo >= 0.0.
     */
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

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    /**
     * Pre: name not empty, price >= 0.0.
     */
    public Utility createUtility(String name, double price) {
        Utility utility = new Utility(name, price);
        utilities.add(utility);
        return utility;
    }

    /**
     * Return a list of the guests in the hotel.
     */
    public ArrayList<String> listHotel() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Hotel: " + name);
        for (Conference conference : conferences) {
            for (Registration registration : conference.getRegistrations()) {
                if (this.equals(registration.getHotel())) {
                    if (registration.getCompanion() != null)
                        list.add("   - " + registration.getParticipant().getName() + " + " + registration.getCompanion().getName() + "\n       Ankomst: " + registration.getArrival() + "\n       Afrejse: " + registration.getDeparture());
                    else
                        list.add("   - " + registration.getParticipant().getName() + "\n       Ankomst: " + registration.getArrival() + "\n       Afrejse: " + registration.getDeparture());
                }
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return name;
    }
}
