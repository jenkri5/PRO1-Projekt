package ex3;

public class Test {

    public static void main(String[] args) {
        Person p1 = new Person("Bo", 10);
        Person p2 = new Person("Lis", 12);
        Person p3 = new Person("Julemanden", 100);

        Gift g1 = new Gift("Mel", 5, p3);
        p1.addGiftReceived(g1);
        Gift g2 = new Gift("Ost", 10, p3);
        p1.addGiftReceived(g2);
        Gift g3 = new Gift("Kul", 0, p3);
        p2.addGiftReceived(g3);
        Gift g4 = new Gift("Tesla", 1000000, p2);
        p1.addGiftReceived(g4);
        Gift g5 = new Gift("So", 42069, p1);
        p2.addGiftReceived(g5);

        System.out.println(p1);
        System.out.println("Total price: " + p1.totalPrice());
        System.out.println("Receives from: " + p1.getGivers());

        System.out.println();


        System.out.println(p2);
        System.out.println("Total price: " + p2.totalPrice());
        System.out.println("Receives from: " + p2.getGivers());
    }

}
