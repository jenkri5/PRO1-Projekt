package ex2.model;

import java.time.LocalDateTime;

public class Reservation {

    private final LocalDateTime start;
    private final LocalDateTime end;

    public Reservation(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

}
