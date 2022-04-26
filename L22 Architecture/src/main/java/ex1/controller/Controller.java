package ex1.controller;

import ex1.model.Company;
import ex1.model.Employee;
import ex1.storage.Storage;

import java.util.ArrayList;

public class Controller {

    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.storeCompany(company);
        return company;
    }

    /**
     * Delete the company.
     * Pre: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.deleteCompany(company);
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // -------------------------------------------------------------------------

    /**
     * Create a new employee.
     * Pre: name not empty, wage >= 0.
     */
    public static Employee createEmployee(String name, int wage, int employmentYear) {
        Employee employee = new Employee(name, wage, employmentYear);
        Storage.storeEmployee(employee);
        return employee;
    }

    /**
     * Delete the employee.
     */
    public static void deleteEmployee(Employee employee) {
        Company company = employee.getCompany();
        if (company != null)
            company.removeEmployee(employee);
        Storage.deleteEmployee(employee);
    }

    /**
     * Update the employee.
     * Pre: wage >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, int employmentYear) {
        employee.setName(name);
        employee.setWage(wage);
        employee.setEmploymentYear(employmentYear);
    }

    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    // -------------------------------------------------------------------------

    /**
     * Add the employee to the company.
     * If the employee is connected to another company, this connected is removed.
     */
    public static void addEmployeeToCompany(Employee employee, Company company) {
        var oldCompany = employee.getCompany();
        if (oldCompany != null)
            oldCompany.removeEmployee(employee);
        company.addEmployee(employee);
    }

    /**
     * Remove the employee's company, if the employee has a company.
     */
    public static void removeCompanyOfEmployee(Employee employee) {
        var company = employee.getCompany();
        if (company != null)
            company.removeEmployee(employee);
    }
}
