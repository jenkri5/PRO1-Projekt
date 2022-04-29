package kas.application.model;

import java.util.ArrayList;

public class Companion {

    private final String name;
    private final Participant participant; // association 0..* --> 1

    /** Pre: name is not empty. */
    public Companion(String name, Participant participant) {
        this.name = name;
        this.participant = participant;
    }

    public String getName() {
        return name;
    }

    public Participant getParticipant() {
        return participant;
    }

}
