package ex1.gui;

import ex1.controller.Controller;
import ex1.model.Company;
import ex1.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmployeeWindow extends Stage {
    private final Employee employee; // nullable

    /**
     * Note: Nullable param employee.
     */
    public EmployeeWindow(String title, Employee employee) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.employee = employee;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfWage = new TextField();
    private final TextField txfEmploymentYear = new TextField();
    private final CheckBox cbxCompany = new CheckBox();
    private final ComboBox<Company> cbbCompany = new ComboBox<>();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHours = new Label("Hourly Wage");
        pane.add(lblHours, 0, 2);

        pane.add(txfWage, 0, 3);

        pane.add(cbxCompany, 0, 4);
        cbxCompany.setText("Company");
        ChangeListener<Boolean> listener = (ov, oldValue, newValue) -> this.selectedCompanyChanged(newValue);
        cbxCompany.selectedProperty().addListener(listener);

        pane.add(cbbCompany, 0, 5);
        cbbCompany.getItems().addAll(Controller.getCompanies());
        cbbCompany.setDisable(true);

        Label lblEmploymentYear = new Label("Employment Year");
        pane.add(lblEmploymentYear, 0, 6);

        pane.add(txfEmploymentYear, 0, 7);
        txfEmploymentYear.setDisable(true);

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    private void initControls() {
        if (employee != null) {
            txfName.setText(employee.getName());
            txfWage.setText("" + employee.getWage());
            Company company = employee.getCompany();
            if (company != null) {
                cbxCompany.setSelected(true);
                cbbCompany.getSelectionModel().select(company);
                txfEmploymentYear.setText("" + employee.getEmploymentYear());
            } else {
                cbbCompany.getSelectionModel().select(0);
                txfEmploymentYear.clear();
            }
        } else {
            txfName.clear();
            txfWage.clear();
            cbbCompany.getSelectionModel().select(0);
            txfEmploymentYear.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }

        int wage = -1;
        try {
            wage = Integer.parseInt(txfWage.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (wage < 0) {
            lblError.setText("Wage is not a positive number");
            return;
        }

        Company company = cbbCompany.getSelectionModel().getSelectedItem();
        boolean companyChecked = cbxCompany.isSelected();

        int employmentYear = -1;
        try {
            if (companyChecked)
                employmentYear = Integer.parseInt(txfEmploymentYear.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (employmentYear < 0 && companyChecked) {
            lblError.setText("Employment Year is not a positive number");
            return;
        }

        if (employee != null) {
            // update existing employee
            Controller.updateEmployee(employee, name, wage, employmentYear);
            if (companyChecked)
                Controller.addEmployeeToCompany(employee, company);
            else
                Controller.removeCompanyOfEmployee(employee);
        } else {
            // create new employee
            Employee newEmployee = Controller.createEmployee(name, wage, employmentYear);
            if (companyChecked)
                Controller.addEmployeeToCompany(newEmployee, company);
        }

        this.hide();
    }

    // -------------------------------------------------------------------------

    private void selectedCompanyChanged(boolean checked) {
        cbbCompany.setDisable(!checked);
        txfEmploymentYear.setDisable(!checked);
    }
}
