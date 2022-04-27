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
    private final String companion; // nullable
    private final Hotel hotel; // nullable, association 1 --> 0..1 Hotel
    private final ArrayList<Excursion> excursions; // association 1 --> 0..* Excursion
    private final ArrayList<Utility> utilities; // association 1 --> 0..* Utility

    public Registration(Conference conference, Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        this.conference = conference;
        this.participant = participant;
        this.isSpeaker = isSpeaker;
        this.arrival = arrival;
        this.departure = departure;
        this.companion = companion;
        this.hotel = hotel;
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

    // nullable return value
    public String getCompanion() {
        return companion;
    }

    // nullable return value
    public Hotel getHotel() {
        return hotel;
    }

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

    public ArrayList<Utility> getUtilities() {
        return new ArrayList<>(utilities);
    }

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
        // TODO
        return "";
    }
}
