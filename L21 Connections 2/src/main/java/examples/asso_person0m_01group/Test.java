package examples.asso_person0m_01group;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        Person p1 = new Person("P1");
        p1.setGroup(g1);
        Person p2 = new Person("P2");
        p2.setGroup(g2);

        System.out.println("G1's persons: " + g1.getPersons());
        System.out.println("G2's persons: " + g2.getPersons());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
        System.out.println();

        p2.removeGroup(); // OBS!
        p2.setGroup(g2);

        System.out.println("G1's persons: " + g1.getPersons());
        System.out.println("G2's persons: " + g2.getPersons());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
    }
}
