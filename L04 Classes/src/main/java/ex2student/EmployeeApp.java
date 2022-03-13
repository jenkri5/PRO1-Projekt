package ex2student;

public class EmployeeApp {

    public static void main(String[] args) {
        Employee e1 = new Employee("Hans Jensen");
        System.out.println("Name: " + e1.getName());
        System.out.println("Trainee? " + e1.isTrainee());
        System.out.println();

        e1.setTrainee(false);
        e1.printEmployee();
        System.out.println();
    }
}
