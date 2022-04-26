package ex1.model;

public class Employee {
    private String name;
    private int wage; // hourly wage
    private int employmentYear; // negative number is unemployed

    // association 0..* --> 0..1 Company
    Company company; // nullable, OBS: package visible

    /** Pre: name not empty, wage >= 0. */
    public Employee(String name, int wage, int employmentYear) {
        this.name = name;
        this.wage = wage;
        this.employmentYear = employmentYear;
    }

    public String getName() {
        return name;
    }

    /** Pre: name not empty. */
    public void setName(String name) {
        this.name = name;
    }

    public int getWage() {
        return wage;
    }

    /** Pre: wage >= 0. */
    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getEmploymentYear() {
        return employmentYear;
    }

    /** Pre: must be employed */
    public void setEmploymentYear(int employmentYear) {
        this.employmentYear = employmentYear;
    }

    @Override
    public String toString() {
        return name + " (kr " + wage + ")";
    }

    // -----------------------------------------------------------------------------

    /** Note: Nullable return value. */
    public Company getCompany() {
        return company;
    }

    // -----------------------------------------------------------------------------

    /**
     * Return the weekly salary of this employee.
     * Return 0, if this employee doesn't have a company.
     */
    public int weeklySalary() {
        int salary = 0;
        if (company != null) {
            salary = wage * company.getHours();
        }
        return salary;
    }
}
