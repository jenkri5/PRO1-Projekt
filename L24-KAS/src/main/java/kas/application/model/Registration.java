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
     * Note: nullable parameter companion, hotel
     * Pre: The participant is not already registered for the conference, arrival is at latest endDate, departure is after arrival and at latest endDate, content of excursions are connected to conference, content of utilities are connected to hotel.
     */
    public Registration(Conference conference, Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companionName, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        this.conference = conference;
        this.participant = participant;
        participant.registrations.add(this);
        this.isSpeaker = isSpeaker;
        this.arrival = arrival;
        this.departure = departure;
        if (companionName != null) {
            companion = createCompanion(companionName, participant, excursions);
        } else
            companion = null;
        this.hotel = hotel;
        this.excursions = excursions;
        this.utilities = utilities;
        participant.conferences.add(conference);
        conference.participants.add(participant);
        if (hotel != null)
            hotel.registrations.add(this);
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

    /** Pre: companionName is not empty. */
    private Companion createCompanion(String companionName, Participant participant, ArrayList<Excursion> excursions) {
        return new Companion(companionName, participant, excursions);
    }

//    @Override
//    public String toString() {
//        return conference.getName();
//    }

}
