package examples.asso_person0m_1group_forced;

public class Person {
    private final String name;

    public Person(String name, Group group) {
        this.name = name;
        this.group = group;
    }

    @Override
    public String toString() {
        return name;
    }

//-----------------------------------------------------

    // association 0..* --> 1 Group
    private Group group;

    public Group getGroup() {
        return group;
    }

    /** Pre: This person is not connected to a group. */
    public void setGroup(Group group) {
        this.group = group;
    }

    /** Pre: This person is connected to a group. */
    public void removeGroup() {
        this.group = null;
    }
}
