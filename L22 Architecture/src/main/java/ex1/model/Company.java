package ex1.model;

import java.util.ArrayList;

public class Company {
    private String name;
    private int hours; // weekly work hours

    // association 0..1 --> 0..* Employee
    private final ArrayList<Employee> employees = new ArrayList<>();

    /** Pre: name not empty, hours >= 0. */
    public Company(String name, int hours) {
        this.name = name;
        this.hours = hours;
    }

    public String getName() {
        return name;
    }

    /** Pre: name not empty. */
    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    /** Pre: hours >= 0. */
    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return name + " (" + hours + " hours)";
    }

    // -----------------------------------------------------------------------------

    public ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    /** Pre: The employee is not connected to a company. */
    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.company = this;
    }

    /** Pre: The employee is connected to this company. */
    public void removeEmployee(Employee employee) {
        employees.remove(employee);
        employee.company = null;
    }

    // -----------------------------------------------------------------------------

    /** Return the count of employees in this company. */
    public int employeesCount() {
        return employees.size();
    }

//    /** Return the total weekly salary of all employees in this company. */
//    public int totalWeeklySalary() {
//        int total = 0;
//        for (Employee emp : employees) {
//            total += emp.weeklySalary();
//        }
//        return total;
//    }
}
