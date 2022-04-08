package examples.compo_group1_0mperson;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");

        Person p1 = g1.createPerson("P1");
        Person p2 = g1.createPerson("P2");

        System.out.println("G1's persons: " + g1.getPersons());
        System.out.println("P1's group: " + p1.getGroup());
        System.out.println("P2's group: " + p2.getGroup());
    }
}
