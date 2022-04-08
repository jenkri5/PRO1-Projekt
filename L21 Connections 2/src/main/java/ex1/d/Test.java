package ex1.d;

public class Test {


    public static void main(String[] args) {
        Person p1 = new Person("Hans", "01010101-0101", "88888888");
        Person p2 = new Person("Liz", "02020202-0202", "80808080");

        Dog d1 = new Dog(1, "SpeedyF40");
        d1.addPerson(p1);
        Dog d2 = new Dog(2,"pepsi");
        d2.addPerson(p1);
        Dog d3 = new Dog(3, "Fido");
        d3.addPerson(p2);

        System.out.println(p1);
        System.out.println(p1.getDogs().toString());

        System.out.println();

        System.out.println(d3);
        System.out.println(d3.getPerson().toString());

        d3.removePerson(p2);
        d3.addPerson(p1);

        System.out.println();

        System.out.println(p1);
        System.out.println(p1.getDogs().toString());
    }

}
