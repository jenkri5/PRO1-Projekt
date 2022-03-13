package ex4;

public class PersonTester {

    public static void main(String[] args) {
        Person p1 = new Person("Bob");
        p1.setAddress("Nordpolen");
        p1.setMonthlySalary(30000);

        System.out.println("Name: " + p1.getName());
        System.out.println("Address: " + p1.getAddress());
        System.out.println("Monthly salary: " + p1.getMonthlySalary());

        System.out.println();

        p1.printPerson();

        System.out.println();

        p1.calculateAnnualSalary();
        System.out.println("Annual salary: " + p1.getAnnualSalary());
    }
}
