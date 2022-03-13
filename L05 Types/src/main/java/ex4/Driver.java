package ex4;

public class Driver {

    public static void main(String[] args) {
        Name name1 = new Name("Piotr", "Suski");
        Name name2 = new Name("Mateusz", "Pawel", "Dziurdz");

        System.out.println(name1.getFullName());
        System.out.println(name2.getFullName());

        System.out.println(name1.getUsername());
        System.out.println(name2.getUsername());

        System.out.println(name1.getInits());
        System.out.println(name2.getInits());

        System.out.println(name1.getCryptoInits(2));
        System.out.println(name2.getCryptoInits(2));

    }
}
