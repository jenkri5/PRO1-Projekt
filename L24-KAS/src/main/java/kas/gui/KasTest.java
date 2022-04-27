package kas.gui;

import kas.application.model.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class KasTest {

    public static void main(String[] args) {

        Participant p1 = new Participant("Finn Madsen", "", "", "", "", "",null, null);
        Participant p2 = new Participant("Niels Petersen", "", "", "", "", "",null, null);
        Participant p3 = new Participant("Ulla Hansen", "", "", "", "", "",null, null);
        Participant p4 = new Participant("Peter Sommer", "", "", "", "", "",null, null);
        Participant p5 = new Participant("Lone Jensen", "", "", "", "", "",null, null);

        Hotel h1 = new Hotel("Den Hvide Svane", 1050.0, 1250.0);
        h1.createUtility("WiFi", 50.0);

        Conference c1 = new Conference("Hav og Himmel", 1500.0, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20));
        c1.createExcursion("Byrundtur, Odense", LocalDate.of(2021, 12, 18), "", 125.0);
        c1.createExcursion("Egeskov", LocalDate.of(2021, 12, 19), "", 75.0);
        c1.createExcursion("Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20), "", 200.0);

        ArrayList<Excursion> e1 = new ArrayList<>();
        ArrayList<Utility> u1 = new ArrayList<>();
        c1.createRegistration(p1, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), null, null, e1, u1);
        System.out.println(c1.getRegistrations().get(0).calculatePrice());

        ArrayList<Excursion> e2 = new ArrayList<>();
        ArrayList<Utility> u2 = new ArrayList<>();
        c1.createRegistration(p2, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), null, h1, e2, u2);
        System.out.println(c1.getRegistrations().get(1).calculatePrice());

        ArrayList<Excursion> e3 = new ArrayList<>();
        e3.add(c1.getExcursions().get(0));
        ArrayList<Utility> u3 = new ArrayList<>();
        c1.createRegistration(p3, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 19), "Hans Hansen", null, e3, u3);
        System.out.println(c1.getRegistrations().get(2).calculatePrice());

        ArrayList<Excursion> e4 = new ArrayList<>();
        e4.add(c1.getExcursions().get(1));
        e4.add(c1.getExcursions().get(2));
        ArrayList<Utility> u4 = new ArrayList<>();
        u4.add(h1.getUtilities().get(0));
        c1.createRegistration(p4, false, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), "Mie Sommer", h1, e4, u4);
        System.out.println(c1.getRegistrations().get(3).calculatePrice());

        ArrayList<Excursion> e5 = new ArrayList<>();
        e5.add(c1.getExcursions().get(0));
        e5.add(c1.getExcursions().get(1));
        ArrayList<Utility> u5 = new ArrayList<>();
        u5.add(h1.getUtilities().get(0));
        c1.createRegistration(p5, true, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20), "Jan Madsen", h1, e5, u5);
        System.out.println(c1.getRegistrations().get(4).calculatePrice());

    }
}
