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

    public ParticipantPane() {
        setPadding(new Insets(20.0));
        setHgap(20.0);
        setVgap(10.0);

        ChangeListener<Participant> listener = (ov, o, n) -> updateControls();
        lvwParticipants.getSelectionModel().selectedItemProperty().addListener(listener);

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

    }

    public void updateControls() {
    }

}
