package kas.gui;

import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kas.application.controller.Controller;
import kas.application.model.Conference;
import kas.application.model.Hotel;

import java.time.LocalDate;
import java.util.ArrayList;

public class ConferenceWindow extends Stage {

    public ConferenceWindow() {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        setTitle("Opret Konference");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final DatePicker dpStartDate = new DatePicker();
    private final DatePicker dpEndDate = new DatePicker();
    private final ChoiceBox<Hotel> cbxHotels = new ChoiceBox<>();
    private final ListView<Hotel> lvwHotels = new ListView<>();
    private final ArrayList<Hotel> hotels = new ArrayList<>();
    private final ListView<String> lvwExcursions = new ListView<>();
    private final ArrayList<String> exNames = new ArrayList<>();
    private final ArrayList<Double> exPrices = new ArrayList<>();
    private final ArrayList<LocalDate> exDates = new ArrayList<>();
    private final Label lblError = new Label();

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Navn");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblPrice = new Label("Pris");
        pane.add(lblPrice, 0, 2);

        pane.add(txfPrice, 0, 3);
        txfPrice.setPrefWidth(200);

        Label lblStartDate = new Label("Start dato");
        pane.add(lblStartDate, 0, 4);

        pane.add(dpStartDate, 0, 5);
        dpStartDate.setPrefWidth(200);
        dpStartDate.setEditable(false);
        dpStartDate.setOnAction(event -> updateDate());

        Label lblEndDate = new Label("Slut dato");
        pane.add(lblEndDate, 0, 6);

        pane.add(dpEndDate, 0, 7);
        dpEndDate.setPrefWidth(200);
        dpEndDate.setEditable(false);
        dpEndDate.setOnAction(event -> updateDate());

        Label lblHotels = new Label("Hoteller");
        pane.add(lblHotels, 0, 8);

        pane.add(cbxHotels, 0, 9);
        cbxHotels.setPrefWidth(150);
        GridPane.setHalignment(cbxHotels, HPos.LEFT);
        cbxHotels.setItems(FXCollections.observableArrayList(Controller.getHotels()));

        Button btnAddHotel = new Button("Tilføj");
        pane.add(btnAddHotel, 0, 9);
        GridPane.setHalignment(btnAddHotel, HPos.RIGHT);
        btnAddHotel.setOnAction(event -> this.addHotel());

        pane.add(lvwHotels, 0, 10);
        lvwHotels.setPrefHeight(75);
        lvwHotels.setPrefWidth(200);

        Label lblExcursions = new Label("Udflugter");
        pane.add(lblExcursions, 0, 11);

        Button btnAddExcursion = new Button("Tilføj");
        pane.add(btnAddExcursion, 0, 11);
        GridPane.setHalignment(btnAddExcursion, HPos.RIGHT);
        btnAddExcursion.setOnAction(event -> this.addExcursion());

        pane.add(lvwExcursions, 0, 12);
        lvwExcursions.setPrefHeight(75);
        lvwExcursions.setPrefWidth(200);

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 13);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 13);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 14);
        lblError.setStyle("-fx-text-fill: red");
    }

    // -------------------------------------------------------------------------

    public LocalDate getStartDate() {
        return dpStartDate.getValue();
    }

    public LocalDate getEndDate() {
        return dpEndDate.getValue();
    }

    private void updateDate() {
        for (int i = 0; i < exDates.size(); i++) {
            if (!exDates.get(i).isAfter(dpStartDate.getValue().minusDays(1)) || !exDates.get(i).isBefore(dpEndDate.getValue().plusDays(1))) {
                exNames.remove(i);
                exPrices.remove(i);
                exDates.remove(i);
                updateDate();
                return;
            }
        }
        lvwExcursions.getItems().clear();
        for (int i = 0; i < exNames.size(); i++) {
            lvwExcursions.getItems().add(exNames.get(i) + "(" + exDates.get(i) + "), " + exPrices.get(i));
        }
    }

    public void addExcursionData(String name, LocalDate date, double price) {
        exNames.add(name);
        exDates.add(date);
        exPrices.add(price);
    }

    private void addHotel() {
        Hotel hotel = cbxHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            hotels.add(hotel);
            lvwHotels.getItems().setAll(hotels);
            cbxHotels.getItems().clear();
            for (Hotel h : Controller.getHotels()) {
                if (!hotels.contains(h))
                    cbxHotels.getItems().add(h);
            }
        }
    }

    private void addExcursion() {
        lblError.setText("");
        if (dpStartDate.getValue() == null) {
            lblError.setText("Ugyldig start dato");
            return;
        }
        if (!dpStartDate.getValue().isAfter(LocalDate.now().minusDays(1))) {
            lblError.setText("Ugyldig start dato");
            return;
        }
        if (dpEndDate.getValue() == null) {
            lblError.setText("Ugyldig slut dato");
            return;
        }
        if (!dpEndDate.getValue().isAfter(dpStartDate.getValue().minusDays(1))) {
            lblError.setText("Ugyldig slut dato");
            return;
        }
        ExcursionWindow dialog = new ExcursionWindow(this);
        dialog.showAndWait();

        lvwExcursions.getItems().clear();
        for (int i = 0; i < exNames.size(); i++) {
            lvwExcursions.getItems().add(exNames.get(i) + "(" + exDates.get(i) + "), " + exPrices.get(i));
        }

    }

    private void cancelAction() {
        hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Udfyld navn");
            return;
        }

        double price = -1.0;
        try {
            price = Double.parseDouble(txfPrice.getText().trim());
        } catch (NumberFormatException e) {
            // do nothing
        }
        if (price < 0) {
            lblError.setText("Ugyldig pris");
            return;
        }

        LocalDate startDate = dpStartDate.getValue();
        if (startDate == null) {
            lblError.setText("Ugyldig start dato");
            return;
        }
        if (!startDate.isAfter(LocalDate.now().minusDays(1))) {
            lblError.setText("Ugyldig start dato");
            return;
        }

        LocalDate endDate = dpEndDate.getValue();
        if (endDate == null) {
            lblError.setText("Ugyldig slut dato");
            return;
        }
        if (!endDate.isAfter(dpStartDate.getValue().minusDays(1))) {
            lblError.setText("Ugyldig slut dato");
            return;
        }

        Controller.createConference(name, price, startDate, endDate);
        Conference conference = Controller.getConferences().get(Controller.getConferences().size() - 1);
        for (Hotel hotel : hotels) {
            Controller.addHotel(conference, hotel);
        }
        for (int i = 0; i < exNames.size(); i++) {
            Controller.createExcursion(conference, exNames.get(i), exDates.get(i), exPrices.get(i));
        }

        hide();
    }

}
