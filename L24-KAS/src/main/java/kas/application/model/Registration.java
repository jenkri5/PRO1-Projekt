package kas.application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration {

    private final Conference conference; // association 1 --> 1 Conference
    private final Participant participant; // association 1 --> 1 Participant
    private final boolean isSpeaker;
    private final LocalDate arrival;
    private final LocalDate departure;
    private final Companion companion; // nullable, association 1 --> 0..1 Companion
    private final Hotel hotel; // nullable, association 1 --> 0..1 Hotel
    private final ArrayList<Excursion> excursions; // association 1 --> 0..* Excursion
    private final ArrayList<Utility> utilities; // association 1 --> 0..* Utility

    /**
     * Pre: conference = Conference, participant = Participant, isSpeaker = boolean, arrival = LocalDate, departure = LocalDate, excursions = ArrayList of Excursion, utilities = ArrayList of Utility.
     */
    public Registration(Conference conference, Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        this.conference = conference;
        this.participant = participant;
        participant.registrations.add(this);
        this.isSpeaker = isSpeaker;
        this.arrival = arrival;
        this.departure = departure;
        if (companion != null) {
            this.companion = new Companion(companion, participant, excursions);
            conference.companions.add(this.companion);
        } else
            this.companion = null;
        this.hotel = hotel;
        if (hotel != null)
            hotel.registrations.add(this);
        this.excursions = excursions;
        this.utilities = utilities;
    }

    public Conference getConference() {
        return conference;
    }

    public Participant getParticipant() {
        return participant;
    }

    public boolean isSpeaker() {
        return isSpeaker;
    }

    public LocalDate getArrival() {
        return arrival;
    }

    public LocalDate getDeparture() {
        return departure;
    }

    /**
     * Note: Nullable return value.
     */
    public Companion getCompanion() {
        return companion;
    }

    /**
     * Note: Nullable return value.
     */
    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

    public ArrayList<Utility> getUtilities() {
        return new ArrayList<>(utilities);
    }

    /**
     * Return the price of the registration.
     */
    public double calculatePrice() {
        double price = 0.0;
        long days = arrival.until(departure, ChronoUnit.DAYS) + 1;
        if (!isSpeaker)
            price += conference.getPrice() * days;
        if (hotel != null) {
            if (companion != null)
                price += hotel.getPriceTwo() * (days - 1);
            else
                price += hotel.getPrice() * (days - 1);
            for (Utility utility : utilities)
                price += utility.getPrice() * (days - 1);
        }
        for (Excursion excursion : excursions)
            price += excursion.getPrice();
        return price;
    }

    @Override
    public String toString() {
        return conference.getName();
    }
}
