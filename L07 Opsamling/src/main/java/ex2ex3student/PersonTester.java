package ex2ex3student;

public class PersonTester {

    public static void main(String[] args) {
        ex2ex3student.Person p1 = new Person("Ib", 2000, 10, 6);
        p1.printPerson();
        System.out.println(p1.calcAge(2021, 11, 7));
        System.out.println(p1.isLeapYear(888));
    }
}
