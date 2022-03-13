package ex2;

public class Employee {
    // The first name of the employee.
    private final String firstName;
    // The last name of the employee.
    private final String lastName;
    // The age of the employee.
    private int age;
    // Whether the employee is a trainee or not.
    private boolean trainee;

    /**
     * Create an employee as a trainee with the given name.
     */
    public Employee(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.trainee = true;
    }

    /**
     * Return the first name of the employee.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Return the last name of the employee.
     */
    public String getLastName() { return lastName; }
    
    /**
     * Return the age of the employee.
     */
    public int getAge() { return age; }

    /**
     * Set the age of the employee.
     */
    public void setAge(int age) { this.age = age; }

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
     * Happy birthday
     */
    public void birthday() {age = age +1; }

    /**
     * Return a description of the employee (for test purposes).
     */
    @Override
    public String toString() {
        return firstName + " (trainee: " + trainee + ")";
    }

    /**
     * Print a description of the employee.
     */
    public void printEmployee() {
        System.out.println("*******************");
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);
        System.out.println("Trainee: " + trainee);
        System.out.println("Age: " + age);
        System.out.println("*******************");
    }
}
