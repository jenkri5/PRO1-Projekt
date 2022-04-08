package ex3;

public class Test {

    public static void main(String[] args) {
        Person p1 = new Person("Bo", 10);
        Person p2 = new Person("Lis", 12);
        Person p3 = new Person("Julemanden", 100);

        Gift g1 = new Gift("Mel", 5, p3);
        g1.setReceiver(p1);
        Gift g2 = new Gift("Ost", 10, p3);
        g2.setReceiver(p1);
        Gift g3 = new Gift("Kul", 0, p3);
        g3.setReceiver(p2);
        Gift g4 = new Gift("Tesla", 1000000, p2);
        g4.setReceiver(p1);
        Gift g5 = new Gift("So", 42069, p1);
        g5.setReceiver(p2);

        System.out.println(p1);
        System.out.println("Total price: " + p1.totalPrice());
        System.out.println("Receives from: " + p1.getGivers());

        System.out.println();


        System.out.println(p2);
        System.out.println("Total price: " + p2.totalPrice());
        System.out.println("Receives from: " + p2.getGivers());
    }

}
