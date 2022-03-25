package demostatic;

public class Person {
    private int id;
    private String firstName;
    private static int lastUsedId = 100;

    public Person(String firstName) {
        this.id = lastUsedId;
        lastUsedId++;
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return id + " " + firstName;
    }
}
