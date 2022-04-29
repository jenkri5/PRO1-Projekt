package kas.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kas.application.controller.Controller;
import kas.application.model.Participant;

public class ParticipantWindow extends Stage {

    private final Participant participant; // nullable

    /** Note: Nullable param employee. */
    public ParticipantWindow(String title, Participant participant) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.participant = participant;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfAddress = new TextField();
    private final TextField txfCity = new TextField();
    private final TextField txfCountry = new TextField();
    private final TextField txfPhone = new TextField();
    private final TextField txfEmail = new TextField();
    private final TextField txfCompany = new TextField();
    private final TextField txfCompanyPhone = new TextField();
    private final Label lblError = new Label();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblAddress = new Label("Adresse");
        pane.add(lblAddress, 0, 2);

        pane.add(txfAddress, 0, 3);
        txfAddress.setPrefWidth(200);

        Label lblCity = new Label("By");
        pane.add(lblCity, 0, 4);

        pane.add(txfCity, 0, 5);
        txfCity.setPrefWidth(200);

        Label lblCountry = new Label("Land");
        pane.add(lblCountry, 0, 6);

        pane.add(txfCountry, 0, 7);
        txfCountry.setPrefWidth(200);

        Label lblPhone = new Label("Telefon");
        pane.add(lblPhone, 0, 8);

        pane.add(txfPhone, 0, 9);
        txfPhone.setPrefWidth(200);

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 0, 10);

        pane.add(txfEmail, 0, 11);
        txfEmail.setPrefWidth(200);

        Label lblCompany = new Label("Firma");
        pane.add(lblCompany, 0, 12);

        pane.add(txfCompany, 0, 13);
        txfCompany.setPrefWidth(200);

        Label lblCompanyPhone = new Label("Firma Telefon");
        pane.add(lblCompanyPhone, 0, 14);

        pane.add(txfCompanyPhone, 0, 15);
        txfCompanyPhone.setPrefWidth(200);

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 16);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 16);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 17);
        lblError.setStyle("-fx-text-fill: red");

        initControls();
    }

    private void initControls() {
        if (participant != null) {
            txfName.setText(participant.getName());
            txfAddress.setText(participant.getAddress());
            txfCity.setText(participant.getCity());
            txfCountry.setText(participant.getCountry());
            txfPhone.setText(participant.getPhone());
            txfEmail.setText(participant.getEmail());
            String company = participant.getCompany();
            if (company != null) {
                txfCompany.setText(participant.getCompany());
                txfCompanyPhone.setText(participant.getCompanyPhone());
            } else {
                txfCompany.clear();
                txfCompanyPhone.clear();
            }
        } else {
            txfName.clear();
            txfAddress.clear();
            txfCity.clear();
            txfCountry.clear();
            txfPhone.clear();
            txfEmail.clear();
            txfCompany.clear();
            txfCompanyPhone.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Udfyld navn");
            return;
        }

        String address = txfAddress.getText().trim();
        if (address.length() == 0) {
            lblError.setText("Udfyld adresse");
            return;
        }

        String city = txfCity.getText().trim();
        if (city.length() == 0) {
            lblError.setText("Udfyld by");
            return;
        }

        String country = txfCountry.getText().trim();
        if (country.length() == 0) {
            lblError.setText("Udfyld land");
            return;
        }

        String phone = txfPhone.getText().trim();
        if (phone.length() == 0) {
            lblError.setText("Udfyld telefon");
            return;
        }

        String email = txfEmail.getText().trim();
        if (email.length() == 0) {
            lblError.setText("Udfyld email");
            return;
        }

        String company = txfCompany.getText().trim();
        String companyPhone = txfCompanyPhone.getText().trim();
        if (company.length() == 0) {
            company = null;
            companyPhone = null;
        } else {
            if (companyPhone.length() == 0) {
                lblError.setText("Udfyld firma telefon");
                return;
            }
        }

        if (participant != null) {
            Controller.updateParticipant(participant, name, address, city, country, phone, email, company, companyPhone);
        } else {
            Controller.createParticipant(name, address, city, country, phone, email, company, companyPhone);
        }

        hide();
    }
}
