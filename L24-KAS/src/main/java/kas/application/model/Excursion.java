package kas.application.model;

import java.time.LocalDate;

public class Excursion {

    private final String name;
    private final LocalDate date;
    private final double price;

    /** Pre: name not empty, date = LocalDate, organizer not empty, price >= 0.0. */
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
