package ex4;

public class Person {

    private final String name;
    private String address;
    private int monthlySalary;
    private double annualSalary;

    public Person(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public void setAddress(String address) { this.address = address; }

    public String getAddress() { return address; }

    public void setMonthlySalary(int monthlySalary) { this.monthlySalary = monthlySalary; }

    public int getMonthlySalary() { return monthlySalary; }

    public double getAnnualSalary() { return annualSalary; }

    public void printPerson() {
        System.out.println("*******************");
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Monthly salary: " + monthlySalary);
        System.out.println("*******************");
    }

    public void calculateAnnualSalary() {
        annualSalary = monthlySalary*12*1.025;
    }
}
