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
import kas.application.model.Conference;
import kas.application.model.Participant;

public class ListPane extends GridPane {

    private final ListView<Conference> lvwConferences = new ListView<>();
    private final TextArea txaList = new TextArea();

    public ListPane() {
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

        Label lblList = new Label("Liste");
        add(lblList, 1, 0);

        add(txaList, 1, 1);
        txaList.setPrefHeight(200.0);
        txaList.setPrefWidth(200.0);
        txaList.setEditable(false);

        HBox hbxButtons = new HBox(10.0);
        add(hbxButtons, 1, 2);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnParticipants = new Button("Deltagere");
        hbxButtons.getChildren().add(btnParticipants);
        btnParticipants.setOnAction(event -> participantsAction());

        Button btnExcursions = new Button("Udflugter");
        hbxButtons.getChildren().add(btnExcursions);
        btnExcursions.setOnAction(event -> excursionsAction());

        Button btnHotels = new Button("Hoteller");
        hbxButtons.getChildren().add(btnHotels);
        btnHotels.setOnAction(event -> hotelsAction());

        if (!lvwConferences.getItems().isEmpty())
            lvwConferences.getSelectionModel().select(0);
    }

    private void updateConference() {
        txaList.clear();
    }

    public void participantsAction() {
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if (conference != null) {
            StringBuilder list = new StringBuilder();
            for (String string : conference.listParticipants())
                list.append(string).append("\n");
            txaList.setText(list.toString().toString());
        } else {
            txaList.clear();
        }
    }

    public void excursionsAction() {
        Conference conference = lvwConferences.getSelectionModel().getSelectedItem();
        if (conference != null) {
            StringBuilder list = new StringBuilder();
            for (String string : conference.listExcursions())
                list.append(string).append("\n");
            txaList.setText(list.toString());
        } else {
            txaList.clear();
        }
    }

    public void hotelsAction() {
        StringBuilder list = new StringBuilder();
        for (String string : Controller.listHotels())
            list.append(string).append("\n");
        txaList.setText(list.toString());
    }
}
