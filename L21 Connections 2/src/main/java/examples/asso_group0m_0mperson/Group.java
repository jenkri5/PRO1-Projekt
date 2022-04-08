package examples.asso_group0m_0mperson;

import java.util.ArrayList;

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

    // association 0..* --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    /** Pre: The person is not connected to this group. */
    public void addPerson(Person person) {
        persons.add(person);
        person.groups.add(this);
    }

    /** Pre: The person is connected to this group. */
    public void removePerson(Person person) {
        persons.remove(person);
        person.groups.remove(this);
    }
}
