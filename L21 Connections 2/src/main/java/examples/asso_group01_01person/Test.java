package examples.asso_group01_01person;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        Person p1 = new Person("P1");
        g1.setPerson(p1);
        Person p2 = new Person("P2");
        g2.setPerson(p2);

        System.out.println("G1's persons: " + g1.getPerson());
        System.out.println("G2's persons: " + g2.getPerson());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
        System.out.println();

        g1.removePerson(); // OBS!
        g2.removePerson(); // OBS!
        g1.setPerson(p2);
        g2.setPerson(p1);

        System.out.println("G1's persons: " + g1.getPerson());
        System.out.println("G2's persons: " + g2.getPerson());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
    }
}
