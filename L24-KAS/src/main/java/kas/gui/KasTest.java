package kas.gui;

import kas.application.controller.Controller;
import kas.application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class KasTest {

    public static void main(String[] args) {
        initStorage();

        ArrayList<Conference> conferences = Controller.getConferences();
        ArrayList<Participant> participants = Controller.getParticipants();

        ArrayList<Excursion> e1 = new ArrayList<>();
        ArrayList<Utility> u1 = new ArrayList<>();
        Controller.createRegistration(conferences.get(0), participants.get(0), false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), null, null, e1, u1);

        ArrayList<Excursion> e2 = new ArrayList<>();
        ArrayList<Utility> u2 = new ArrayList<>();
        Controller.createRegistration(conferences.get(0), participants.get(1),false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), null, conferences.get(0).getHotels().get(0), e2, u2);

        ArrayList<Excursion> e3 = new ArrayList<>();
        e3.add(conferences.get(0).getExcursions().get(0));
        ArrayList<Utility> u3 = new ArrayList<>();
        Controller.createRegistration(conferences.get(0), participants.get(2), false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), "Hans Hansen", null, e3, u3);

        ArrayList<Excursion> e4 = new ArrayList<>();
        e4.add(conferences.get(0).getExcursions().get(1));
        e4.add(conferences.get(0).getExcursions().get(2));
        ArrayList<Utility> u4 = new ArrayList<>();
        u4.add(conferences.get(0).getHotels().get(0).getUtilities().get(0));
        Controller.createRegistration(conferences.get(0), participants.get(3), false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), "Mie Sommer", conferences.get(0).getHotels().get(0), e4, u4);

        ArrayList<Excursion> e5 = new ArrayList<>();
        e5.add(conferences.get(0).getExcursions().get(0));
        e5.add(conferences.get(0).getExcursions().get(1));
        ArrayList<Utility> u5 = new ArrayList<>();
        u5.add(conferences.get(0).getHotels().get(0).getUtilities().get(0));
        Controller.createRegistration(conferences.get(0), participants.get(4), true, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), "Jan Madsen", conferences.get(0).getHotels().get(0), e5, u5);

        System.out.println(conferences.get(0).getRegistrations().get(0).getParticipant().getName() + ": " + conferences.get(0).getRegistrations().get(0).calculatePrice());
        System.out.println(conferences.get(0).getRegistrations().get(1).getParticipant().getName() + ": " + conferences.get(0).getRegistrations().get(1).calculatePrice());
        System.out.println(conferences.get(0).getRegistrations().get(2).getParticipant().getName() + ": " + conferences.get(0).getRegistrations().get(2).calculatePrice());
        System.out.println(conferences.get(0).getRegistrations().get(3).getParticipant().getName() + ": " + conferences.get(0).getRegistrations().get(3).calculatePrice());
        System.out.println(conferences.get(0).getRegistrations().get(4).getParticipant().getName() + ": " + conferences.get(0).getRegistrations().get(4).calculatePrice());

        System.out.println(conferences.get(0).listParticipants());
        System.out.println(conferences.get(0).listExcursions());
        System.out.println(Controller.listHotels());
    }

    public static void initStorage() {
        Controller.createConference("Hav og Himmel", 1500.0, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20));

        Controller.createHotel("Den Hvide Svane", 1050.0, 1250.0);
        Controller.createHotel("Hotel Phønix", 700.0, 800.0);
        Controller.createHotel("Pension Tusinfryd", 500.0, 600.0);

        Controller.createParticipant("Finn Madsen", "", "", "", "43214321", "","IBM", "124124");
        Controller.createParticipant("Niels Petersen", "", "", "", "88888888", "",null, null);
        Controller.createParticipant("Ulla Hansen", "", "", "", "11111111", "",null, null);
        Controller.createParticipant("Peter Sommer", "", "", "", "12345678", "",null, null);
        Controller.createParticipant("Lone Jensen", "", "", "", "87654321", "",null, null);

        Controller.addHotel(Controller.getConferences().get(0), Controller.getHotels().get(0));
        Controller.addHotel(Controller.getConferences().get(0), Controller.getHotels().get(1));
        Controller.addHotel(Controller.getConferences().get(0), Controller.getHotels().get(2));

        Controller.createExcursion(Controller.getConferences().get(0), "Byrundtur, Odense", LocalDate.of(2021, 12, 18), 125.0);
        Controller.createExcursion(Controller.getConferences().get(0), "Egeskov", LocalDate.of(2021, 12, 19), 75.0);
        Controller.createExcursion(Controller.getConferences().get(0), "Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20), 200.0);

        Controller.createUtility(Controller.getHotels().get(0), "WiFi", 50.0);
        Controller.createUtility(Controller.getHotels().get(1), "Bad", 200.0);
        Controller.createUtility(Controller.getHotels().get(1), "WiFi", 75.0);
        Controller.createUtility(Controller.getHotels().get(2), "Morgenmad", 100.0);
    }

}
