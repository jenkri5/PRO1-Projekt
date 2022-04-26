package kas.application.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Registration {

    private final Conference conference;
    private final Participant participant;
    private final boolean isSpeaker;
    private final LocalDate arrival;
    private final LocalDate departure;
    private final String companion; // nullable
    private final Hotel hotel; // nullable
    private final ArrayList<Excursion> excursions;
    private final ArrayList<Utility> utilities;

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
