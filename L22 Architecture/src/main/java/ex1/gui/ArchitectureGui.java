package ex1.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ArchitectureGui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Architecture Demo");
        BorderPane pane = new BorderPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private void initContent(BorderPane pane) {
        TabPane tabPane = new TabPane();
        this.initTabPane(tabPane);
        pane.setCenter(tabPane);
    }

    private void initTabPane(TabPane tabPane) {
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tabCompanies = new Tab("Companies");
        tabPane.getTabs().add(tabCompanies);

        CompanyPane companyPane = new CompanyPane();
        tabCompanies.setContent(companyPane);
        tabCompanies.setOnSelectionChanged(event -> companyPane.updateControls());

        Tab tabEmployees = new Tab("Employees");
        tabPane.getTabs().add(tabEmployees);

        EmployeePane employeePane = new EmployeePane();
        tabEmployees.setContent(employeePane);
        tabEmployees.setOnSelectionChanged(event -> employeePane.updateControls());
    }
}
