package examples.compo_group1_0mperson;

public class Person {
    private final String name;

    Person(String name) { // OBS: package visible
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    //-----------------------------------------------------

    // composition --> 1 Group
    Group group; // OBS: package visible

    public Group getGroup() {
        return group;
    }
}
