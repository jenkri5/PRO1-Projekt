package kas.application.model;

import java.time.LocalDateTime;

public class Excursion {

    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final String organizer;
    private final String description;
    private final double price;

    public Excursion(String name, LocalDateTime startTime, LocalDateTime endTime, String organizer, String description, double price) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organizer = organizer;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public String getOrganizer() {
        return organizer;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
