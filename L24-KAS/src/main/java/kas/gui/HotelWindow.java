package kas.gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kas.application.controller.Controller;
import kas.application.model.Hotel;

import java.util.ArrayList;

public class HotelWindow extends Stage {

    public HotelWindow() {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);

        setTitle("Opret Hotel");
        GridPane pane = new GridPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfPrice = new TextField();
    private final TextField txfPriceTwo = new TextField();
    private final ListView<String> lvwUtilities = new ListView<>();
    private final ArrayList<String> utNames = new ArrayList<>();
    private final ArrayList<Double> utPrice = new ArrayList<>();
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

        Label lblPriceTwo = new Label("Pris 2");
        pane.add(lblPriceTwo, 0, 4);

        pane.add(txfPriceTwo, 0, 5);
        txfPriceTwo.setPrefWidth(200);

        Label lblUtilities = new Label("Tillæg");
        pane.add(lblUtilities, 0, 6);

        Button btnAddUtility = new Button("Tilføj");
        pane.add(btnAddUtility, 0, 6);
        GridPane.setHalignment(btnAddUtility, HPos.RIGHT);
        btnAddUtility.setOnAction(event -> this.addUtility());

        pane.add(lvwUtilities, 0, 7);
        lvwUtilities.setPrefHeight(75);
        lvwUtilities.setPrefWidth(200);

        Button btnCancel = new Button("Annuller");
        pane.add(btnCancel, 0, 8);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 8);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 9);
        lblError.setStyle("-fx-text-fill: red");
    }

    public void addUtilityData(String name, double price) {
        utNames.add(name);
        utPrice.add(price);
    }

    private void addUtility() {
        UtilityWindow dialog = new UtilityWindow(this);
        dialog.showAndWait();

        lvwUtilities.getItems().clear();
        for (int i = 0; i < utNames.size(); i++) {
            lvwUtilities.getItems().add(utNames.get(i) + ", " + utPrice.get(i) + " kr");
        }
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
            lblError.setText("Ugyldigt pris");
            return;
        }

        double priceTwo = -1.0;
        try {
            priceTwo = Double.parseDouble(txfPriceTwo.getText().trim());
        } catch (NumberFormatException e) {
            // do nothing
        }
        if (priceTwo < 0) {
            lblError.setText("Ugyldigt pris 2");
            return;
        }

        Controller.createHotel(name, price, priceTwo);
        Hotel hotel = Controller.getHotels().get(Controller.getHotels().size() - 1);
        for (int i = 0; i < utNames.size(); i++) {
            Controller.createUtility(hotel, utNames.get(i), utPrice.get(i));
        }

        hide();
    }

    private void cancelAction() {
        hide();
    }
}
