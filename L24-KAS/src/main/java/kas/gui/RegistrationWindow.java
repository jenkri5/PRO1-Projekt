package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kas.application.controller.Controller;
import kas.application.model.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

public class RegistrationWindow extends Stage {

    private Participant participant; // nullable
    private Conference conference; // nullable

    public RegistrationWindow(Participant participant, Conference conference) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        this.participant = participant;
        this.conference = conference;

        setTitle("Tilmelding");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    public RegistrationWindow(Participant participant) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
        setHeight(HEIGHT);

        this.participant = participant;
        conference = null;

        setTitle("Tilmeld " + participant.getName());
        GridPane pane = new GridPane();
        TextField txfParticipant = new TextField(participant.getName());
        txfParticipant.setEditable(false);
        pane.add(txfParticipant, 0, 1);
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);

    }

    public RegistrationWindow(Conference conference) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        participant = null;
        this.conference = conference;

        setTitle("Tilmeld " + conference.getName());
        GridPane pane = new GridPane();
        pane.add(new Label(conference.getName()), 0, 3);
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final ChoiceBox<Participant> cbxParticipants = new ChoiceBox<>();
    private final ChoiceBox<Conference> cbxConferences = new ChoiceBox<>();
    private final CheckBox cbxSpeaker = new CheckBox("Foredragsholder");
    private final ChoiceBox<Hotel> cbxHotels = new ChoiceBox<>();
    private final DatePicker dpArrival = new DatePicker();
    private final DatePicker dpDeparture = new DatePicker();
    private final TextField txfCompanion = new TextField();
    private final VBox vBoxExcursions = new VBox(10.0);
    private final ArrayList<CheckBox> cbxExcursions = new ArrayList<>();
    private final VBox vBoxUtilities = new VBox(10.0);
    private final ArrayList<CheckBox> cbxUtilities = new ArrayList<>();
    private final Label lblError = new Label();
    private final double HEIGHT = 500.0;

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        if (participant == null) {
            ChangeListener<Participant> listenerParticipant = (ov, o, n) -> updateParticipant();
            cbxParticipants.getSelectionModel().selectedItemProperty().addListener(listenerParticipant);
        }

        if (conference == null) {
            ChangeListener<Conference> listenerConference = (ov, o, n) -> updateConference();
            cbxConferences.getSelectionModel().selectedItemProperty().addListener(listenerConference);
        }

        txfCompanion.textProperty().addListener(event -> updateExcursions());

        ChangeListener<Hotel> listenerHotel = (ov, o, n) -> updateHotel();
        cbxHotels.getSelectionModel().selectedItemProperty().addListener(listenerHotel);

        Label lblParticipant = new Label("Deltager");
        pane.add(lblParticipant, 0, 0);

        if (participant == null) {
            ArrayList<Participant> participants = new ArrayList<>();
            for (Participant participant : Controller.getParticipants())
                if (!conference.getParticipants().contains(participant))
                    participants.add(participant);
            cbxParticipants.setItems(FXCollections.observableArrayList(participants));

            pane.add(cbxParticipants, 0, 1);
            cbxParticipants.setPrefWidth(200);

            if (!cbxParticipants.getItems().isEmpty())
                cbxParticipants.getSelectionModel().select(0);
        }


        Label lblConference = new Label("Konference");
        pane.add(lblConference, 0, 2);

        if (conference == null) {
            ArrayList<Conference> conferences = new ArrayList<>();
            for (Conference conference : Controller.getConferences())
                if (!participant.getConferences().contains(conference))
                    conferences.add(conference);
            cbxConferences.setItems(FXCollections.observableArrayList(conferences));

            pane.add(cbxConferences, 0, 3);
            pane.setValignment(cbxConferences, VPos.TOP);
            cbxConferences.setPrefWidth(200);

            if (!cbxConferences.getItems().isEmpty())
                cbxConferences.getSelectionModel().select(0);
        }

        pane.add(cbxSpeaker, 0, 4);

        if (conference != null) {
            dpArrival.setValue(conference.getStartDate());
            dpDeparture.setValue(conference.getEndDate());
        } else {
            dpArrival.setValue(LocalDate.now());
            dpDeparture.setValue(LocalDate.now());
        }

        Label lblArrival = new Label("Ankomst");
        pane.add(lblArrival, 0, 5);
        pane.add(dpArrival, 0, 6);

        Label lblDeparture = new Label("Afgang");
        pane.add(lblDeparture, 0, 7);
        pane.add(dpDeparture, 0, 8);

        Label lblCompanion = new Label("Ledsager");
        pane.add(lblCompanion, 1, 0);

        pane.add(txfCompanion, 1, 1);
        txfCompanion.setPrefWidth(200);


        Label lblExcursions = new Label("Udflugter");
        pane.add(lblExcursions, 1, 2);

        pane.add(vBoxExcursions, 1, 3, 1, 6);

        Label lblHotel = new Label("Hotel");
        pane.add(lblHotel, 0, 9);

        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(null);
        if (conference != null)
            hotels.addAll(conference.getHotels());
        cbxHotels.setItems(FXCollections.observableArrayList(hotels));
        cbxHotels.getSelectionModel().select(0);

        pane.add(cbxHotels, 0, 10);
        pane.setValignment(cbxHotels, VPos.TOP);
        cbxHotels.setPrefWidth(200);

        Label lblUtilities = new Label("Tillæg");
        pane.add(lblUtilities, 1, 9);
        pane.add(vBoxUtilities, 1, 10);

        HBox hBoxButtons = new HBox(10);
        hBoxButtons.setAlignment(Pos.BASELINE_RIGHT);
        Button btnCancel = new Button("Annuller");
        hBoxButtons.getChildren().add(btnCancel);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        hBoxButtons.getChildren().add(btnOK);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(hBoxButtons, 1, 11);

        pane.add(lblError, 0, 11);
        lblError.setStyle("-fx-text-fill: red");

    }

    private void updateParticipant() {
        participant = cbxParticipants.getSelectionModel().getSelectedItem();
    }

    private void updateConference() {
        conference = cbxConferences.getSelectionModel().getSelectedItem();

        ArrayList<Participant> participants = new ArrayList<>();
        for (Participant participant : Controller.getParticipants())
            if (!conference.getParticipants().contains(participant))
                participants.add(participant);
        cbxParticipants.setItems(FXCollections.observableArrayList(participants));

        if (!cbxParticipants.getItems().isEmpty())
            cbxParticipants.getSelectionModel().select(0);

        dpArrival.setValue(conference.getStartDate());
        dpDeparture.setValue(conference.getEndDate());

        ArrayList<Hotel> hotels = new ArrayList<>();
        hotels.add(null);
        hotels.addAll(conference.getHotels());
        cbxHotels.setItems(FXCollections.observableArrayList(hotels));
        cbxHotels.getSelectionModel().select(0);

        updateExcursions();
    }

    private void updateExcursions() {
        vBoxExcursions.getChildren().clear();
        cbxExcursions.clear();
        if (!txfCompanion.getText().isEmpty() && conference != null) {
            for (Excursion excursion : conference.getExcursions()) {
                cbxExcursions.add(new CheckBox(excursion.getName() + " (" + excursion.getDate() + "), " + excursion.getPrice() + " kr"));
            }
            vBoxExcursions.getChildren().addAll(cbxExcursions);
        }
    }

    private void updateHotel() {
        Hotel hotel = cbxHotels.getSelectionModel().getSelectedItem();
        vBoxUtilities.getChildren().clear();
        cbxUtilities.clear();

        if (hotel != null) {
            for (Utility utility : hotel.getUtilities()) {
                cbxUtilities.add(new CheckBox(utility.getName() + ", " + utility.getPrice() + " kr"));
            }
            vBoxUtilities.getChildren().addAll(cbxUtilities);
        }

    }

    private void okAction() {

//        participant = cbxParticipants.getSelectionModel().getSelectedItem();
        if (participant == null) {
            lblError.setText("Vælg deltager");
            return;
        }

//        conference = cbxConferences.getSelectionModel().getSelectedItem();
        if (conference == null) {
            lblError.setText("Vælg konference");
            return;
        }

        boolean isSpeaker = cbxSpeaker.isSelected();

        LocalDate arrival = dpArrival.getValue();
        if (!arrival.isAfter(conference.getStartDate().minusDays(1)) || !arrival.isBefore(conference.getEndDate().plusDays(1))) {
            lblError.setText("Ugyldig ankomst");
            return;
        }

        LocalDate departure = dpDeparture.getValue();
        if (!departure.isAfter(arrival.minusDays(1)) || !departure.isBefore(conference.getEndDate().plusDays(1))) {
            lblError.setText("Ugyldig afgang");
            return;
        }

        String companion = null;
        if (!txfCompanion.getText().isEmpty())
            companion = txfCompanion.getText().trim();

        Hotel hotel = cbxHotels.getSelectionModel().getSelectedItem();

        ArrayList<Excursion> excursions = new ArrayList<>();
        for (int i = 0; i < cbxExcursions.size(); i++) {
            if (cbxExcursions.get(i).isSelected())
                excursions.add(conference.getExcursions().get(i));
        }

        ArrayList<Utility> utilities = new ArrayList<>();
        if (!cbxUtilities.isEmpty())
            for (int i = 0; i < cbxUtilities.size(); i++)
                if (cbxUtilities.get(i).isSelected())
                    utilities.add(hotel.getUtilities().get(i));

        Controller.createRegistration(conference, participant, isSpeaker, arrival, departure, companion, hotel, excursions, utilities);

        hide();
    }

    private void cancelAction() {
        hide();
    }
}
