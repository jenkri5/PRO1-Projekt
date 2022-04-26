package ex2.model;

public class Seat {

    private final int id;
    private final Area area;

    public Seat(int id, Area area) {
        this.id = id;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

}
