package examples.asso_group01_01person;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");
        Group g2 = new Group("G2");

        Person p1 = new Person("P1");
        p1.setGroup(g1);
        Person p2 = new Person("P2");
        p2.setGroup(g2);

        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
        System.out.println();

        p1.removeGroup(); // OBS!
        p2.removeGroup(); // OBS!
        p1.setGroup(g2);
        p2.setGroup(g1);

        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
    }
}
