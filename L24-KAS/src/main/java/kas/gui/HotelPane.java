package kas.gui;

import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import kas.application.controller.Controller;
import kas.application.model.Hotel;
import kas.application.model.Registration;
import kas.application.model.Utility;

public class HotelPane extends GridPane {

    private final ListView<Hotel> lvwHotels = new ListView<>();
    private final TextArea txaHotel = new TextArea();
    private final ListView<Registration> lvwRegistrations = new ListView<>();
    private final TextArea txaRegistration = new TextArea();

    public HotelPane() {
        setPadding(new Insets(20.0));
        setHgap(20.0);
        setVgap(10.0);

        ChangeListener<Hotel> listenerHotel = (ov, o, n) -> updateHotel();
        lvwHotels.getSelectionModel().selectedItemProperty().addListener(listenerHotel);

        ChangeListener<Registration> listenerRegistration = (ov, o, n) -> updateRegistration();
        lvwRegistrations.getSelectionModel().selectedItemProperty().addListener(listenerRegistration);

        Label lblConferences = new Label("Hoteller");
        add(lblConferences, 0, 0);

        add(lvwHotels, 0, 1);
        lvwHotels.setPrefHeight(200.0);
        lvwHotels.setPrefWidth(200.0);
        lvwHotels.getItems().setAll(Controller.getHotels());

        HBox hbxHotelButtons = new HBox(10.0);
        add(hbxHotelButtons, 0, 2);
        hbxHotelButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxHotelButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreateHotel = new Button("Opret");
        hbxHotelButtons.getChildren().add(btnCreateHotel);
        btnCreateHotel.setOnAction(event -> createHotelAction());

        Label lblHotel = new Label("Hotel");
        add(lblHotel, 1, 0);

        add(txaHotel, 1, 1);
        txaHotel.setPrefHeight(200.0);
        txaHotel.setPrefWidth(200.0);
        txaHotel.setEditable(false);

        Label lblRegistrations = new Label("Tilmeldinger");
        add(lblRegistrations, 2, 0);

        add(lvwRegistrations, 2, 1);
        lvwRegistrations.setPrefHeight(200.0);
        lvwRegistrations.setPrefWidth(200.0);
        if (lvwHotels.getSelectionModel().getSelectedItem() != null)
            lvwRegistrations.getItems().setAll(lvwHotels.getSelectionModel().getSelectedItem().getRegistrations());
        lvwRegistrations.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Registration item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    if (item.getCompanion() != null)
                        setText(item.getParticipant().getName() + " + " + item.getCompanion().getName());
                    else
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

        if (!lvwHotels.getItems().isEmpty())
            lvwHotels.getSelectionModel().select(0);
    }

    public void updateHotel() {
        Hotel hotel = lvwHotels.getSelectionModel().getSelectedItem();
        if (hotel != null) {
            StringBuilder description = new StringBuilder("Navn: " + hotel.getName()
                    + "\nPris: " + hotel.getPrice() + "/" + hotel.getPriceTwo());
            if (!hotel.getUtilities().isEmpty()) {
                description.append("\nTillæg");
                for (Utility utility : hotel.getUtilities()) {
                    description.append("\n - ").append(utility.getName()).append(", ").append(utility.getPrice()).append(" kr");
                }
            }
            txaHotel.setText(description.toString());
        } else {
            txaHotel.clear();
        }

        if (hotel != null)
            lvwRegistrations.getItems().setAll(hotel.getRegistrations());

        if (!lvwRegistrations.getItems().isEmpty())
            lvwRegistrations.getSelectionModel().select(0);
    }

    private void updateRegistration() {
        Registration registration = lvwRegistrations.getSelectionModel().getSelectedItem();
        if (registration != null) {
            StringBuilder description = new StringBuilder("Hotel: " + registration.getHotel() + "\nGæst(er): " + registration.getParticipant().getName());
            if (registration.getCompanion() != null)
                description.append(" + ").append(registration.getCompanion().getName());
            description.append("\nAnkomst: ").append(registration.getArrival()).append("\nAfrejse: ").append(registration.getDeparture());
            if (!registration.getUtilities().isEmpty()) {
                description.append("\nTillæg: ");
                for (Utility utility : registration.getUtilities())
                    description.append("\n - ").append(utility.getName()).append(", ").append(utility.getPrice()).append(" kr");
            }
            txaRegistration.setText(description.toString());
        } else {
            txaRegistration.clear();
        }
    }

    private void createHotelAction() {
        HotelWindow dialog = new HotelWindow();
        dialog.showAndWait();

        lvwHotels.getItems().setAll(Controller.getHotels());

        int index = lvwHotels.getItems().size() - 1;
        lvwHotels.getSelectionModel().select(index);
    }

}
