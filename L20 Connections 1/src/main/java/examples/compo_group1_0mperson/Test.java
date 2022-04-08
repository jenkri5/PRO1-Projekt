package examples.compo_group1_0mperson;

public class Test {

    public static void main(String[] args) {
        Group g1 = new Group("G1");

        g1.createPerson("P1");
        g1.createPerson("P2");
        System.out.println("G1's persons: " + g1.getPersons());
    }
}
