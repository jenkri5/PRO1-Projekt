package examples.asso_group01_01person;

public class Group {
    private final String name;

    public Group(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //-----------------------------------------------------

    // association 0..1 --> 0..1 Person
    private Person person; // nullable

    /** Note: Nullable return value. */
    public Person getPerson() {
        return person;
    }

    /** Pre: The person is not connected to a group,
        this group is not connected to a person. */
    public void setPerson(Person person) {
        this.person = person;
        person.group = this;
    }

    /** Pre: This group is connected to a person. */
    public void removePerson() {
        Person person = this.person;
        this.person = null;
        person.group = null;
    }
}
