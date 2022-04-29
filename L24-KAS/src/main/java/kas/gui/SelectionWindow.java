package kas.gui;

import javafx.stage.Stage;
import kas.application.controller.Controller;
import kas.application.model.Conference;
import kas.application.model.Participant;
import kas.application.model.Registration;

import java.util.ArrayList;

public class SelectionWindow extends Stage {

    private final Participant participant;
    private final Conference conference;

    public SelectionWindow(Participant participant) {
        this.participant = participant;
        conference = null;
        ArrayList<Conference> conferences = Controller.getConferences();
        for (Conference conference : conferences) {
            for (Registration registration : participant.getRegistrations()) {
                if (registration.getConference() == conference) {
                    conferences.remove(conference);
                }
            }
        }
    }
}
