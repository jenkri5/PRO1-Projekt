package examples.asso_person0m_01group;

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

    // association 0..1 --> 0..* Person
    final ArrayList<Person> persons = new ArrayList<>(); // OBS: package visible

    public ArrayList<Person> getPersons() {
        return new ArrayList<>(persons);
    }
}
