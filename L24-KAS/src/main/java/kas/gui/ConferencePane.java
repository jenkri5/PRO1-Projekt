package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import kas.application.controller.Controller;
import kas.application.model.Conference;
import kas.application.model.Participant;

public class ConferencePane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();

    public ConferencePane() {
        setPadding(new Insets(20.0));
        setHgap(20.0);
        setVgap(10.0);

        ChangeListener<Conference> listenerConference = (ov, o, n) -> updateConference();
        lvwConferences.getSelectionModel().selectedItemProperty().addListener(listenerConference);

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

        if (!lvwConferences.getItems().isEmpty())
            lvwConferences.getSelectionModel().select(0);
    }

    public void updateConference() {
    }

    private void createConferenceAction() {
    }

    private void createRegistrationAction() {
    }

}
