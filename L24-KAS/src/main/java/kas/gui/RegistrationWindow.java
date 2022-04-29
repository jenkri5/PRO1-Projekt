package kas.gui;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import kas.application.model.Conference;
import kas.application.model.Participant;

public class RegistrationWindow extends Stage {

    private final Participant participant; // nullable
    private final Conference conference; // nullable

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

        this.participant = participant;
        conference = null;

        setTitle("Tilmeld " + participant.getName());
        GridPane pane = new GridPane();
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
        initContent(pane);

        Scene scene = new Scene(pane);
        setScene(scene);
    }

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
    }
}
