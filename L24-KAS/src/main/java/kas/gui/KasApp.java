package kas.gui;

import javafx.application.Application;
import kas.application.controller.Controller;
import kas.application.model.Conference;
import kas.application.model.Excursion;
import kas.application.model.Participant;
import kas.application.model.Utility;

import java.time.LocalDate;
import java.util.ArrayList;

public class KasApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(KasGui.class);
    }

    public static void initStorage() {
        Controller.createConference("Hav og Himmel", 1500.0, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20));
        Controller.createConference("Tag og Skimmel", 3000.0,LocalDate.of(2022, 4, 8), LocalDate.of(2022, 4, 10));

        Controller.createHotel("Den Hvide Svane", 1050.0, 1250.0);
        Controller.createHotel("Hotel Phønix", 700.0, 800.0);
        Controller.createHotel("Pension Tusinfryd", 500.0, 600.0);

        Controller.createParticipant("Finn Madsen", "Vænget 1", "Hov", "Danmark", "43214321", "finnmadsen1@gmail.com","IBM", "12341234");
        Controller.createParticipant("Niels Petersen", "Svinget 2", "Tarm", "Danmark", "88888888", "nptrsn@msn.com",null, null);
        Controller.createParticipant("Ulla Hansen", "Gaden 3", "Løvel", "Danmark", "11111111", "ulla.hansen123@yahoo.com",null, null);
        Controller.createParticipant("Peter Sommer", "Vejen 4, 3-th", "Aarhus", "Danmark", "12345678", "therealpetersommer@sommer.dk",null, null);
        Controller.createParticipant("Lone Jensen", "Väg 5", "Malmö", "Sverige", "87654321", "ljensen32@icloud.com","IKEA", "23412341");
        Controller.createParticipant("John Doe", "Adresse", "By", "Land", "Telefon", "Email", "Firma", "Firma telefon");

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
    }

}
