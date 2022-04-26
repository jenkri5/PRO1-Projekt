package ex1.gui;

import ex1.controller.Controller;
import ex1.model.Company;
import ex1.model.Employee;
import javafx.application.Application;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee bob = Controller.createEmployee("Bob Dole", 210, 1991);
        Controller.addEmployeeToCompany(bob, ibm);

        Employee alice = Controller.createEmployee("Alice Schmidt", 250, 1994);
        Controller.addEmployeeToCompany(alice, ibm);

        Employee george = Controller.createEmployee("George Down", 150, 2002);
        Controller.addEmployeeToCompany(george, amd);

        Employee rita = Controller.createEmployee("Rita Uphill", 300, 2010);
        Controller.addEmployeeToCompany(rita, sled);

        Controller.createEmployee("John Doe", 100, -1);
    }
}
