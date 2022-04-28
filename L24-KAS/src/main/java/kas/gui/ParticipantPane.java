package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import kas.application.controller.Controller;
import kas.application.model.Excursion;
import kas.application.model.Participant;
import kas.application.model.Registration;
import kas.application.model.Utility;

public class ParticipantPane extends GridPane {

    private final ListView<Participant> lvwParticipants = new ListView<>();
    private final TextArea txaParticipant = new TextArea();
    private final ListView<Registration> lvwRegistrations = new ListView<>();
    private final TextArea txaRegistration = new TextArea();

    public ParticipantPane() {
        setPadding(new Insets(20.0));
        setHgap(20.0);
        setVgap(10.0);

        ChangeListener<Participant> listenerParticipant = (ov, o, n) -> updateParticipant();
        lvwParticipants.getSelectionModel().selectedItemProperty().addListener(listenerParticipant);

        ChangeListener<Registration> listenerRegistration = (ov, o, n) -> updateRegistration();
        lvwRegistrations.getSelectionModel().selectedItemProperty().addListener(listenerRegistration);

        Label lblParticipants = new Label("Deltagere");
        add(lblParticipants, 0, 0);

        add(lvwParticipants, 0, 1);
        lvwParticipants.setPrefHeight(200.0);
        lvwParticipants.setPrefWidth(200.0);
        lvwParticipants.getItems().setAll(Controller.getParticipants());

        HBox hbxParticipantButtons = new HBox(10.0);
        add(hbxParticipantButtons, 0, 2);
        hbxParticipantButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxParticipantButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreateParticipant = new Button("Opret");
        hbxParticipantButtons.getChildren().add(btnCreateParticipant);
        btnCreateParticipant.setOnAction(event -> createParticipantAction());

        Button btnUpdateParticipant = new Button("Opdater");
        hbxParticipantButtons.getChildren().add(btnUpdateParticipant);
        btnUpdateParticipant.setOnAction(event -> updateParticipantAction());

        Label lblParticipant = new Label("Deltager");
        add(lblParticipant, 1, 0);

        add(txaParticipant, 1, 1);
        txaParticipant.setPrefHeight(200.0);
        txaParticipant.setPrefWidth(200.0);
        txaParticipant.setEditable(false);

        Label lblRegistrations = new Label("Tilmeldinger");
        add(lblRegistrations, 2, 0);

        add(lvwRegistrations, 2, 1);
        lvwRegistrations.setPrefHeight(200.0);
        lvwRegistrations.setPrefWidth(200.0);
        if (lvwParticipants.getSelectionModel().getSelectedItem() != null)
            lvwRegistrations.getItems().setAll(lvwParticipants.getSelectionModel().getSelectedItem().getRegistrations());

        HBox hbxRegistrationButtons = new HBox(10.0);
        add(hbxRegistrationButtons, 2, 2);
        hbxRegistrationButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxRegistrationButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreateRegistration = new Button("Opret");
        hbxRegistrationButtons.getChildren().add(btnCreateRegistration);
        btnCreateRegistration.setOnAction(event -> createRegistrationAction());

        Label lblRegistration = new Label("Tilmelding");
        add(lblRegistration, 3, 0);

        add(txaRegistration, 3, 1);
        txaRegistration.setPrefHeight(200.0);
        txaRegistration.setPrefWidth(200.0);
        txaRegistration.setEditable(false);

        if (!lvwParticipants.getItems().isEmpty())
            lvwParticipants.getSelectionModel().select(0);
    }

    public void updateParticipant() {
        Participant participant = lvwParticipants.getSelectionModel().getSelectedItem();
        if (participant != null) {
            String description = "Navn: " + participant.getName()
                    + "\nAdresse: " + participant.getAddress()
                    + "\nBy: " + participant.getCity()
                    + "\nLand: " + participant.getCountry()
                    + "\nTelefon: " + participant.getPhone()
                    + "\nEmail: " + participant.getEmail();
            if (participant.getCompany() != null)
                description += "\nFirma: " + participant.getCompany()
                        + "\nFirma telefon: " + participant.getCompanyPhone();
            txaParticipant.setText(description);
        } else {
            txaParticipant.clear();
        }

        if (participant != null)
            lvwRegistrations.getItems().setAll(participant.getRegistrations());

        if (!lvwRegistrations.getItems().isEmpty())
            lvwRegistrations.getSelectionModel().select(0);
    }

    private void updateRegistration() {
        Registration registration = lvwRegistrations.getSelectionModel().getSelectedItem();
        if (registration != null) {
            StringBuilder description = new StringBuilder("Konference: " + registration.getConference().getName() + "\nDeltager: " + registration.getParticipant().getName() + "\nForedragsholder: ");
            if (registration.isSpeaker())
                description.append("Ja");
            else
                description.append("Nej");
            description.append("\nAnkomst: ").append(registration.getArrival()).append("\nAfrejse: ").append(registration.getDeparture());
            if (registration.getCompanion() != null)
                description.append("\nLedsager: ").append(registration.getCompanion().getName());
            if (!registration.getExcursions().isEmpty()) {
                description.append("\nUdflugter: ");
                for (Excursion excursion : registration.getExcursions())
                    description.append("\n - ").append(excursion.getName());
            }
            if (registration.getHotel() != null)
                description.append("\nHotel: ").append(registration.getHotel().getName());
            if (!registration.getUtilities().isEmpty()) {
                description.append("\nTillæg: ");
                for (Utility utility : registration.getUtilities())
                    description.append("\n - ").append(utility.getName());
            }
            description.append("\nPris: ").append(registration.calculatePrice());
            txaRegistration.setText(description.toString());
        } else {
            txaRegistration.clear();
        }
    }

    private void createParticipantAction() {
    }

    private void updateParticipantAction() {
    }

    private void createRegistrationAction() {
    }

}
