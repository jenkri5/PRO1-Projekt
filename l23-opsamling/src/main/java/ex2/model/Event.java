package ex2.model;

public class Event {

    private final String name;
    private final boolean isPublic;

    public Event(String name, boolean isPublic) {
        this.name = name;
        this.isPublic = isPublic;
    }

    public String getName() {
        return name;
    }

    public boolean isPublic() {
        return isPublic;
    }

}
