package examples.compo_group1_0mperson;

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

    // composition 1 --> 0..* Person
    private final ArrayList<Person> persons = new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }

    public Person createPerson(String name) {
        Person person = new Person(name);
        persons.add(person);
        person.group = this;
        return person;
    }
}
