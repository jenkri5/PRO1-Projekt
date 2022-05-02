package kas.storage;

import kas.application.model.Conference;
import kas.application.model.Hotel;
import kas.application.model.Participant;

import java.util.ArrayList;

public class Storage {

    private static final ArrayList<Conference> conferences = new ArrayList<>();
    private static final ArrayList<Hotel> hotels = new ArrayList<>();
    private static final ArrayList<Participant> participants = new ArrayList<>();

    public static ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }

    public static void storeConference(Conference conference) {
        conferences.add(conference);
    }

    public static void deleteConference(Conference conference) {
        conferences.remove(conference);
    }

    public static ArrayList<Hotel> getHotels() {
        return new ArrayList<>(hotels);
    }

    public static void storeHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    public static void deleteHotel(Hotel hotel) {
        hotels.remove(hotel);
    }

    public static ArrayList<Participant> getParticipants() {
        return new ArrayList<>(participants);
    }

    public static void storeParticipant(Participant participant) {
        participants.add(participant);
    }

    public static void deleteParticipant(Participant participant) {
        participants.remove(participant);
    }

}
