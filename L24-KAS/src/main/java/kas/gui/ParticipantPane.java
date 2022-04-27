package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import kas.application.controller.Controller;
import kas.application.model.Participant;
import kas.application.model.Registration;

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

        Label lblParticipant = new Label("Deltager");
        add(lblParticipant, 1, 0);

        add(txaParticipant, 1, 1);
        txaParticipant.setPrefHeight(200.0);
        txaParticipant.setPrefWidth(200.0);
        txaParticipant.setEditable(false);

        if (!lvwParticipants.getItems().isEmpty())
            lvwParticipants.getSelectionModel().select(0);

        Label lblRegistrations = new Label("Tilmeldinger");
        add(lblRegistrations, 0 , 2);

        add(lvwRegistrations, 2, 1);
        lvwRegistrations.setPrefHeight(200.0);
        lvwRegistrations.setPrefWidth(200.0);
        lvwRegistrations.getItems().setAll(lvwParticipants.getSelectionModel().getSelectedItem().getRegistrations());

        if (!lvwRegistrations.getItems().isEmpty())
            lvwRegistrations.getSelectionModel().select(0);

    }

    public void updateParticipant() {
        Participant participant = lvwParticipants.getSelectionModel().getSelectedItem();
        if (participant != null) {
            String string = "Navn: " + participant.getName()
                    + "\nAdresse: " + participant.getAddress()
                    + "\nBy: " + participant.getCity()
                    + "\nLand: " + participant.getCountry()
                    + "\nTelefon: " + participant.getPhone()
                    + "\nEmail: " + participant.getEmail();
            if (participant.getCompany() != null)
                string += "\nFirma: " + participant.getCompany()
                        + "\nFirma telefon: " + participant.getCompanyPhone();
            txaParticipant.setText(string);
        } else {
            txaParticipant.clear();
        }

        lvwRegistrations.getItems().setAll(participant.getRegistrations());

        if (!lvwRegistrations.getItems().isEmpty())
            lvwRegistrations.getSelectionModel().select(0);
    }

    private void updateRegistration() {
    }

}
