package ex1;

public class Test {


    public static void main(String[] args) {
        Person p1 = new Person("Hans", "01010101-0101", "88888888");
        Person p2 = new Person("Liz", "02020202-0202", "80808080");

        Dog d1 = new Dog(1, "SpeedyF40");
        p1.addDog(d1);
        Dog d2 = new Dog(2,"pepsi");
        p1.addDog(d2);
        Dog d3 = new Dog(3, "Fido");
        p2.addDog(d3);

        System.out.println(p1);
        System.out.println(p1.getDogs().toString());

        System.out.println();

        System.out.println(d3);
        System.out.println(d3.getPerson().toString());

        p2.removeDog(d3);
        p1.addDog(d3);

        System.out.println();

        System.out.println(p1);
        System.out.println(p1.getDogs().toString());
    }

}
