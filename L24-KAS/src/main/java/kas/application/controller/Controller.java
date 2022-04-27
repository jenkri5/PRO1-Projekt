package kas.application.controller;

import kas.application.model.*;
import kas.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static void initStorage() {
        createConference("Hav og Himmel", 1500.0, LocalDate.of(2021, 12, 18), LocalDate.of(2021, 12, 20));

        createHotel("Den Hvide Svane", 1050.0, 1250.0);
        createHotel("Hotel Phønix", 700.0, 800.0);
        createHotel("Pension Tusinfryd", 500.0, 600.0);

        createParticipant("Finn Madsen", "", "", "", "43214321", "","IBM", "124124");
        createParticipant("Niels Petersen", "", "", "", "88888888", "",null, null);
        createParticipant("Ulla Hansen", "", "", "", "11111111", "",null, null);
        createParticipant("Peter Sommer", "", "", "", "12345678", "",null, null);
        createParticipant("Lone Jensen", "", "", "", "87654321", "",null, null);

        addHotel(getConferences().get(0), getHotels().get(0));
        addHotel(getConferences().get(0), getHotels().get(1));
        addHotel(getConferences().get(0), getHotels().get(2));

        createExcursion(getConferences().get(0), "Byrundtur, Odense", LocalDate.of(2021, 12, 18), "", 125.0);
        createExcursion(getConferences().get(0), "Egeskov", LocalDate.of(2021, 12, 19), "", 75.0);
        createExcursion(getConferences().get(0), "Trapholt Museum, Kolding", LocalDate.of(2021, 12, 20), "", 200.0);

        createUtility(getHotels().get(0), "WiFi", 50.0);
        createUtility(getHotels().get(1), "Bad", 200.0);
        createUtility(getHotels().get(1), "WiFi", 75.0);
        createUtility(getHotels().get(2), "Morgenmad", 100.0);
    }

    /**
     * Create a new conference.
     * Pre: name not empty, price >= 0.0, startDate = LocalDate later than now, endDate = LocalDate later than startDate.
     */
    public static Conference createConference(String name, double price, LocalDate startDate, LocalDate endDate) {
        Conference conference = new Conference(name, price, startDate, endDate);
        Storage.storeConference(conference);
        return conference;
    }

    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    /**
     * Delete a conference.
     * Pre: conference = Conference.
     */
    public static void deleteConference(Conference conference) {
        Storage.deleteConference(conference);
    }

    /**
     * Create a new hotel.
     * Pre: name not empty, price >= 0.0, startDate = LocalDate later than now, endDate = LocalDate later than startDate.
     */
    public static Hotel createHotel(String name, double price, double priceTwo) {
        Hotel hotel = new Hotel(name, price, priceTwo);
        Storage.storeHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();
    }

    /**
     * Delete a hotel.
     * Pre: hotel = Hotel.
     */
    public static void deleteHotel(Hotel hotel) {
        Storage.deleteHotel(hotel);
    }

    /**
     * Create a new participant.
     * Pre: name not empty, address not empty, city not empty, country not empty, phone not empty, email not empty.
     */
    public static Participant createParticipant(String name, String address, String city, String country, String phone, String email, String company, String companyPhone) {
        Participant participant = new Participant(name, address, city, country, phone, email, company, companyPhone);
        Storage.storeParticipant(participant);
        return participant;
    }

    public static ArrayList<Participant> getParticipants() {
        return Storage.getParticipants();
    }

    /**
     * Update a participant.
     * Pre: participant = Participant, name not empty, address not empty, city not empty, country not empty, phone not empty, email not empty.
     */
    public static void updateParticipant(Participant participant, String name, String address, String city, String country, String phone, String email, String company, String companyPhone) {
        participant.setName(name);
        participant.setAddress(address);
        participant.setCity(city);
        participant.setCountry(country);
        participant.setPhone(phone);
        participant.setEmail(email);
        if (!company.equals(""))
            participant.setCompany(company);
        if (!company.equals(""))
            participant.setCompanyPhone(companyPhone);
    }

    /**
     * Delete a participant.
     * Pre: participant = Participant.
     */
    public static void deleteParticipant(Participant participant) {
        Storage.deleteParticipant(participant);
    }

    /**
     * Add a hotel to a conference
     * Pre: conference = Conference, hotel = Hotel.
     */
    public static void addHotel(Conference conference, Hotel hotel) {
        conference.addHotel(hotel);
    }

    /**
     * Create an excursion in a conference
     * Pre: conference = Conference, name is not empty, date = LocalDate between conference startDate and endDate, organizer is not empty, price >= 0.0.
     */
    public static void createExcursion(Conference conference, String name, LocalDate date, String organizer, double price) {
        conference.createExcursion(name, date, organizer, price);
    }

    /**
     * Create a registration to a conference
     * Pre: conference = Conference, participant = Participant, isSpeaker = boolean, arrival = LocalDate between conference startDate and endDate, departure = LocalDate between arrival and conference endDate
     */
    public static void createRegistration(Conference conference, Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companion, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        conference.createRegistration(participant, isSpeaker, arrival, departure, companion, hotel, excursions, utilities);
    }

    /**
     * Create a utility in a hotel
     * Pre: hotel = Hotel, name is not empty, price >= 0.0.
     */
    public static void createUtility(Hotel hotel, String name, double price) {
        hotel.createUtility(name, price);
    }

    /**
     * Return a list of the hotels for each conference.
     */
    public static ArrayList<String> listHotels() {
        ArrayList<String> list = new ArrayList<>();
        for (Hotel hotel : Storage.getHotels()) {
            list.add(hotel.getName());
            for (Conference conference :Storage.getConferences()) {
                if (conference.getHotels().contains(hotel)) {
                    list.add(conference.getName());
                    for (Registration registration : conference.getRegistrations()) {
                        if (registration.getHotel() != null) {
                            if (registration.getHotel().equals(hotel)) {
                                if (registration.getCompanion() != null)
                                    list.add(registration.getParticipant().getName() + " + " + registration.getCompanion());
                                else
                                    list.add(registration.getParticipant().getName());
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

}
