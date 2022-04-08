package examples.asso_group01_0mperson;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        Person p1 = new Person("P1");
        g1.addPerson(p1);
        Person p2 = new Person("P2");
        g1.addPerson(p2);

        System.out.println("G1's persons: " + g1.getPersons());
        System.out.println("G2's persons: " + g2.getPersons());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
        System.out.println();

        g1.removePerson(p2); // OBS!
        g2.addPerson(p2);

        System.out.println("G1's persons: " + g1.getPersons());
        System.out.println("G2's persons: " + g2.getPersons());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
    }
}
