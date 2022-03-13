package ex2student;

public class Employee {
    // The name of the employee.
    private final String name;
    // Whether the employee is a trainee or not.
    private boolean trainee;

    /**
     * Create an employee as a trainee with the given name.
     */
    public Employee(String name) {
        this.name = name;
        this.trainee = true;
    }

    /**
     * Return the name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Return the trainee state of the employee.
     */
    public boolean isTrainee() {
        return trainee;
    }

    /**
     * Set the trainee state of the employee.
     */
    public void setTrainee(boolean trainee) {
        this.trainee = trainee;
    }

    /**
     * Return a description of the employee (for test purposes).
     */
    @Override
    public String toString() {
        return name + " (trainee: " + trainee + ")";
    }

    /**
     * Print a description of the employee.
     */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("Name: " + name);
        System.out.println("Trainee: " + trainee);
        System.out.println("*******************");
    }
}
