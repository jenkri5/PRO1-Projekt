package examples.aggre_group01_0mperson;

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

    // aggregation 0..1 --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person createPerson(String name) {
        Person person = new Person(name);
        persons.add(person);
        return person;
    }

    /** Pre: The person is not connected to a group. */
    public void addPerson(Person person) {
        persons.add(person);
    }

    /** Pre: The person is connected to this group. */
    public void removePerson(Person person) {
        persons.remove(person);
    }
}
