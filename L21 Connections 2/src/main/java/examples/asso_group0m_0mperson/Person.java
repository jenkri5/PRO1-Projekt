package examples.asso_group0m_0mperson;

import java.util.ArrayList;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //-----------------------------------------------------

    // association 0..* --> 0..* Group
    final ArrayList<Group> groups = new ArrayList<>(); // OBS: package visible

    public ArrayList<Group> getGroups() {
        return new ArrayList<>(groups);
    }
}
