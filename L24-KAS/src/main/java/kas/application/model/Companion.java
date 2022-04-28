package kas.application.model;

import java.util.ArrayList;

public class Companion {

    private final String name;
    private final Participant participant; // association 0..* --> 1
    private final ArrayList<Excursion> excursions; // association 0..* --> 0..* Excursion

    /** Pre: name is not empty, participant = Participant, excursions may be empty. */
    public Companion(String name, Participant participant, ArrayList<Excursion> excursions) {
        this.name = name;
        this.participant = participant;
        this.excursions = new ArrayList<>(excursions);
        for (Excursion excursion : excursions)
            excursion.companions.add(this);
    }

    public String getName() {
        return name;
    }

    public Participant getParticipant() {
        return participant;
    }

    public ArrayList<Excursion> getExcursions() {
        return new ArrayList<>(excursions);
    }

}
