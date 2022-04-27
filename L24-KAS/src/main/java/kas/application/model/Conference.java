package kas.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {

    private final String name;
    private final double price; // per day
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ArrayList<Excursion> excursions = new ArrayList<>();
    private final ArrayList<Registration> registrations = new ArrayList<>();

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

    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public Excursion createExcursion(String name, LocalDate date, String organizer, double price) {
        Excursion excursion = new Excursion(name, date, organizer, price);
        excursions.add(excursion);
        return excursion;
    }

    public Registration createRegistration(Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        Registration registration = new Registration(this, participant, isSpeaker, arrival, departure, companion, hotel, excursions, utilities);
        registrations.add(registration);
        return registration;
    }

    public ArrayList<String> getParticipantList() {
        ArrayList<String> participantList = new ArrayList<>();
        for (Registration registration : registrations)
            participantList.add(registration.getParticipant().getName());
        return participantList;
    }

    public ArrayList<String> getExcursionList() {
        ArrayList<String> excursionList = new ArrayList<>();
        return excursionList;
    }

    public ArrayList<String> getHotelList() {
        ArrayList<String> hotelList = new ArrayList<>();
        return hotelList;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
