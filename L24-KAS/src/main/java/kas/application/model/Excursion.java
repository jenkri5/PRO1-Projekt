package kas.application.model;

import java.time.LocalDate;

public class Excursion {

    private final String name;
    private final LocalDate date;
    private final String organizer;
    private final double price;

    public Excursion(String name, LocalDate date, String organizer, double price) {
        this.name = name;
        this.date = date;
        this.organizer = organizer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getOrganizer() {
        return organizer;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        // TODO
        return "";
    }
}
