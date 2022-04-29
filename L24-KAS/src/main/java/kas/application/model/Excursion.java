package kas.application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Excursion {

    private final String name;
    private final LocalDate date;
    private final double price;
    final ArrayList<Companion> companions = new ArrayList<>(); // association 0..* --> 0..* Companion

    /** Pre: name not empty, date is between startDate and endDate, organizer not empty, price >= 0.0. */
    public Excursion(String name, LocalDate date, double price) {
        this.name = name;
        this.date = date;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getPrice() {
        return price;
    }

}
