package kas.gui;

import javafx.application.Application;
import kas.application.controller.Controller;

import java.time.LocalDate;

public class KasApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(KasGui.class);
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
