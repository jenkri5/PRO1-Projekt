package examples.asso_group01_01person;

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

    // association 0..1 --> 0..1 Group
    private Group group; // nullable

    /** Note: Nullable return value. */
    public Group getGroup() {
        return group;
    }

    /** Pre: This person is not connected to a group,
        the group is not connected to a person. */
    public void setGroup(Group group) {
        this.group = group;
    }

    /** Pre: This person is connected to a group. */
    public void removeGroup() {
        this.group = null;
    }
}
