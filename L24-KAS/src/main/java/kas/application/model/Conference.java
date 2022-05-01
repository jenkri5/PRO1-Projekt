package kas.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Conference {

    private final String name;
    private final double price; // per day
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final ArrayList<Hotel> hotels = new ArrayList<>(); // association 0..* --> 0..* Hotel
    private final ArrayList<Excursion> excursions = new ArrayList<>(); // composition 1 --> 0..* Excursion
    private final ArrayList<Registration> registrations = new ArrayList<>(); // composition 1 --> 0..* Registration
    final ArrayList<Participant> participants = new ArrayList<>(); // association 0..* --> 0..* Participant


    /** Pre: name not empty, price >= 0.0, startDate is later than now, endDate is later than startDate. */
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

    public ArrayList<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }

    /** Pre: The hotel is not connected to this conference. */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
        hotel.conferences.add(this);
    }

    /** Pre: name not empty, date is between startDate and endDate, organizer not empty, price >= 0.0. */
    public Excursion createExcursion(String name, LocalDate date, double price) {
        Excursion excursion = new Excursion(name, date, price);
        excursions.add(excursion);
        return excursion;
    }

    /** Pre: participant is not already registered, arrival is between startDate and endDate, departure is between arrival and endDate. */
    public Registration createRegistration(Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        Registration registration = new Registration(this, participant, isSpeaker, arrival, departure, companion, hotel, excursions, utilities);
        registrations.add(registration);
        return registration;
    }

    /**
     * Return a list of the participants for this conference.
     */
    public ArrayList<String> listParticipants() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Konference: " + name);
        for (Registration registration : registrations) {
            String s = "  - " + registration.getParticipant().getName();
            if (registration.getParticipant().getCompany() != null)
                s += " (" + registration.getParticipant().getCompany() + ")";
            if (registration.getCompanion() != null)
                s += " + " + registration.getCompanion().getName();
            if (registration.isSpeaker())
                s += ", foredragsholder";
            list.add(s);
        }
        return list;
    }

    /**
     * Return a list of the excursions for this conference.
     */
    public ArrayList<String> listExcursions() {
        ArrayList<String> list = new ArrayList<>();
        list.add("Konference: " + name);
        for (Excursion excursion : excursions) {
            list.add("  Udflugt: " + excursion.getName() + " (" + excursion.getDate() + ")");
            for (Companion companion : excursion.companions)
                list.add("    - " + companion.getName() + " (" + companion.getParticipant().getName() + ", " + companion.getParticipant().getPhone() + ")");
        }
        return list;
    }

    @Override
    public String toString() {
        return name;
    }
}
