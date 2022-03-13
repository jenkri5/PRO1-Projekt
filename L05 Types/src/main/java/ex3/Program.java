package ex3;

public class Program {

    public static void main(String[] args) {

        String ord1 = "Datamatiker";
        String ord2 = "Uddannelsen";

        // A
        ord1 = ord1.toUpperCase();
        System.out.println(ord1);

        // B
        ord2 = ord2.toLowerCase();
        System.out.println(ord2);

        // C
        System.out.println(ord1 + " " + ord2);

        // D
        String ord3 = ord1 + " " + ord2;
        System.out.println(ord3);

        // E
        System.out.println(ord3.length());

        // F
        System.out.println(ord1.substring(0, 7));

        // G
        System.out.println(ord2.substring(2, 7));

        // H
        System.out.println(ord3.substring(ord3.length()/2));

    }
}
