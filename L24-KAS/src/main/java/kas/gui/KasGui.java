package kas.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;

public class KasGui extends Application {
    
    @Override
    public void start(Stage stage) {
        stage.setTitle("KAS");
        TabPane pane = new TabPane();
        initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void initContent(TabPane pane) {
        pane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        Tab tabParticipants = new Tab("Deltagere");
        pane.getTabs().add(tabParticipants);

        ParticipantPane participantPane = new ParticipantPane();
        tabParticipants.setContent(participantPane);
        tabParticipants.setOnSelectionChanged(event -> participantPane.updateParticipant());

        Tab tabConferences = new Tab("Konferencer");
        pane.getTabs().add(tabConferences);

        ConferencePane conferencePane = new ConferencePane();
        tabConferences.setContent(conferencePane);
        tabConferences.setOnSelectionChanged(event -> conferencePane.updateConference());

        Tab tabHotels = new Tab("Hoteller");
        pane.getTabs().add(tabHotels);

        HotelPane hotelPane = new HotelPane();
        tabHotels.setContent(hotelPane);
        tabHotels.setOnSelectionChanged(event -> hotelPane.updateHotel());

        Tab tabLists = new Tab("Lister");
        pane.getTabs().add(tabLists);

        ListPane listPane = new ListPane();
        tabLists.setContent(listPane);
        tabLists.setOnSelectionChanged(event -> listPane.updateConference());
    }

}
