package ex2;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans", "Jensen", 24);
        System.out.println("Name: " + e1.getFirstName() + " " + e1.getLastName());
        System.out.println("Age: " + e1.getAge());
        System.out.println("Trainee? " + e1.isTrainee());
        System.out.println();

        e1.setTrainee(false);
        e1.printEmployee();
        System.out.println();

        e1.setAge(25);
        System.out.println("Age: " + e1.getAge());

        e1.birthday();
        System.out.println("Age: " + e1.getAge());

    }
}
