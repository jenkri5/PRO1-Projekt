package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import kas.application.controller.Controller;
import kas.application.model.*;

public class ConferencePane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();
    private final TextArea txaConference = new TextArea();
    private final ListView<Registration> lvwRegistrations = new ListView<>();
    private final TextArea txaRegistration = new TextArea();

    public ConferencePane() {
        setPadding(new Insets(20.0));
        setHgap(20.0);
        setVgap(10.0);

        ChangeListener<Conference> listenerConference = (ov, o, n) -> updateConference();
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listenerConference);

        ChangeListener<Registration> listenerRegistration = (ov, o, n) -> updateRegistration();
        lvwRegistrations.getSelectionModel().selectedItemProperty().addListener(listenerRegistration);

        Label lblConferences = new Label("Konferencer");
        add(lblConferences, 0, 0);

        add(lvwConferences, 0, 1);
        lvwConferences.setPrefHeight(200.0);
        lvwConferences.setPrefWidth(200.0);
        lvwConferences.getItems().setAll(Controller.getConferences());

        HBox hbxConferenceButtons = new HBox(10.0);
        add(hbxConferenceButtons, 0, 2);
        hbxConferenceButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxConferenceButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreateConference = new Button("Opret");
        hbxConferenceButtons.getChildren().add(btnCreateConference);
        btnCreateConference.setOnAction(event -> createConferenceAction());

        Button btnCreateRegistration = new Button("Tilmeld");
        hbxConferenceButtons.getChildren().add(btnCreateRegistration);
        btnCreateRegistration.setOnAction(event -> createRegistrationAction());

        Label lblParticipant = new Label("Konference");
        add(lblParticipant, 1, 0);

        add(txaConference, 1, 1);
        txaConference.setPrefHeight(200.0);
        txaConference.setPrefWidth(200.0);
        txaConference.setEditable(false);

        Label lblRegistrations = new Label("Tilmeldinger");
        add(lblRegistrations, 2, 0);

        add(lvwRegistrations, 2, 1);
        lvwRegistrations.setPrefHeight(200.0);
        lvwRegistrations.setPrefWidth(200.0);
        if (lvwConferences.getSelectionModel().getSelectedItem() != null)
            lvwRegistrations.getItems().setAll(lvwConferences.getSelectionModel().getSelectedItem().getRegistrations());
        lvwRegistrations.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Registration item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getParticipant().getName());
                }
            }
        });

        Label lblRegistration = new Label("Tilmelding");
        add(lblRegistration, 3, 0);

        add(txaRegistration, 3, 1);
        txaRegistration.setPrefHeight(200.0);
        txaRegistration.setPrefWidth(200.0);
        txaRegistration.setEditable(false);

        if (!lvwConferences.getItems().isEmpty())
            lvwConferences.getSelectionModel().select(0);
    }

    public void updateConference() {
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if (conference != null) {
            StringBuilder description = new StringBuilder("Navn: " + conference.getName()
                    + "\nPris: " + conference.getPrice()
                    + "\nStartdato: " + conference.getStartDate()
                    + "\nSlutdato: " + conference.getEndDate());
            if (!conference.getHotels().isEmpty()) {
                description.append("\nHoteller: ");
                for (Hotel hotel : conference.getHotels()) {
                    description.append("\n - ").append(hotel.getName());
                }
            }
            if (!conference.getExcursions().isEmpty()) {
                description.append("\nUdflugter: ");
                for (Excursion excursion : conference.getExcursions()) {
                    description.append("\n - ").append(excursion.getName());
                }
            }
            txaConference.setText(description.toString());
        } else {
            txaConference.clear();
        }

        if (conference != null)
            lvwRegistrations.getItems().setAll(conference.getRegistrations());

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

    private void createConferenceAction() {
        ConferenceWindow dialog = new ConferenceWindow();
        dialog.showAndWait();

        lvwConferences.getItems().setAll(Controller.getConferences());

        int index = lvwConferences.getItems().size() - 1;
        lvwConferences.getSelectionModel().select(index);
    }

    private void createRegistrationAction() {
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if (conference == null)
            return;

        RegistrationWindow dialog = new RegistrationWindow(conference);
        dialog.showAndWait();

        lvwRegistrations.getItems().setAll(conference.getRegistrations());
        int index = lvwRegistrations.getItems().size() - 1;
        lvwRegistrations.getSelectionModel().select(index);
    }

}
