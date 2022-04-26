package ex1.gui;

import ex1.controller.Controller;
import ex1.model.Company;
import ex1.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class CompanyPane extends GridPane {
    private final TextField txfName = new TextField();
    private final TextField txfHours = new TextField();
    private final TextArea txaEmployees = new TextArea();
    private final ListView<Company> lvwCompanies = new ListView<>();

    public CompanyPane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblComp = new Label("Companies");
        this.add(lblComp, 0, 0);

        this.add(lvwCompanies, 0, 1, 1, 3);
        lvwCompanies.setPrefWidth(200);
        lvwCompanies.setPrefHeight(200);
        lvwCompanies.getItems().setAll(Controller.getCompanies());

        ChangeListener<Company> listener = (ov, o, n) -> this.selectedCompanyChanged();
        lvwCompanies.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        this.add(txfName, 2, 1);
        txfName.setEditable(false);

        Label lblHours = new Label("Weekly Hours:");
        this.add(lblHours, 1, 2);

        this.add(txfHours, 2, 2);
        txfHours.setEditable(false);

        Label lblEmployees = new Label("Employees:");
        this.add(lblEmployees, 1, 3);
        GridPane.setValignment(lblEmployees, VPos.BASELINE);
        lblEmployees.setPadding(new Insets(4, 0, 4, 0));

        this.add(txaEmployees, 2, 3);
        txaEmployees.setPrefWidth(200);
        txaEmployees.setPrefHeight(100);
        txaEmployees.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 4, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        if (!lvwCompanies.getItems().isEmpty())
            lvwCompanies.getSelectionModel().select(0);
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        CompanyWindow dialog = new CompanyWindow("Create Company", null);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        lvwCompanies.getItems().setAll(Controller.getCompanies());
        int index = lvwCompanies.getItems().size() - 1;
        lvwCompanies.getSelectionModel().select(index);
    }

    private void updateAction() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        CompanyWindow dialog = new CompanyWindow("Update Company", company);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwCompanies.getSelectionModel().getSelectedIndex();
        lvwCompanies.getItems().setAll(Controller.getCompanies());
        lvwCompanies.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company == null)
            return;

        if (company.employeesCount() == 0) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Delete Company");
            alert.setHeaderText("Are you sure?");
            Optional<ButtonType> result = alert.showAndWait();

            // wait for the modal dialog to close

            if (result.isPresent() && (result.get() == ButtonType.OK)) {
                Controller.deleteCompany(company);
                lvwCompanies.getItems().setAll(Controller.getCompanies());
                this.updateControls();
            }

        } else {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.initOwner(this.getScene().getWindow());
            alert.setTitle("Delete Company");
            alert.setHeaderText("Can't delete a company that has employees");
            alert.show();

            // wait for the modal dialog to close
        }
    }

    // -------------------------------------------------------------------------

    private void selectedCompanyChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Company company = lvwCompanies.getSelectionModel().getSelectedItem();
        if (company != null) {
            txfName.setText(company.getName());
            txfHours.setText("" + company.getHours());
            StringBuilder sb = new StringBuilder();
            for (Employee emp : company.getEmployees()) {
                sb.append(emp).append("\n");
            }
            txaEmployees.setText(sb.toString());
        } else {
            txfName.clear();
            txfHours.clear();
            txaEmployees.clear();
        }
    }
}
