package kas.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {

    private final String name;
    private final double price; // per day
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ArrayList<Hotel> hotels = new ArrayList<>(); // association 1 --> 0..* Hotel
    private final ArrayList<Excursion> excursions = new ArrayList<>(); // composition 1 --> 0..* Excursion
    private final ArrayList<Registration> registrations = new ArrayList<>(); // aggregation 1 --> 0..* Registration

    /** Pre: name not empty, price >= 0.0, startDate = LocalDate later than now, endDate = LocalDate later than startDate. */
    public Conference(String name, double price, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    /** Pre: hotel = Hotel. */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /** Pre: name not empty, date = LocalDate between startDate and endDate, organizer not empty, price >= 0.0. */
    public Excursion createExcursion(String name, LocalDate date, String organizer, double price) {
        Excursion excursion = new Excursion(name, date, organizer, price);
        excursions.add(excursion);
        return excursion;
    }

    /** Pre: participant = Participant, isSpeaker = boolean, arrival = LocalDate between startDate and endDate, departure = LocalDate between arrival and endDate, excursions = ArrayList of Excursion may be empty, utilities = ArrayList of Utility may be empty. */
    public Registration createRegistration(Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        Registration registration = new Registration(this, participant, isSpeaker, arrival, departure, companion, hotel, excursions, utilities);
        registrations.add(registration);
        return registration;
    }

    /**
     * Return a list of the participants for this conference.
     */
    public ArrayList<String> createParticipantList() {
        ArrayList<String> participantList = new ArrayList<>();
        for (Registration registration : registrations)
            participantList.add(registration.getParticipant().getName());
        return participantList;
    }

    /**
     * Return a list of the excursions for this conference.
     */
    public ArrayList<String> createExcursionList() {
        ArrayList<String> excursionList = new ArrayList<>();
        return excursionList;
    }

    /**
     * Return a list of the hotels for this conference.
     */
    public ArrayList<String> createHotelList() {
        ArrayList<String> hotelList = new ArrayList<>();
        return hotelList;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
