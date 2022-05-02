package kas.application.controller;

import kas.application.model.*;
import kas.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    /**
     * Create a new conference.
     * Pre: name not empty, price >= 0.0, startDate is later than now, endDate is later than startDate.
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
     * Create a new hotel.
     * Pre: name not empty, price >= 0.0, priceTwo >= 0.0.
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
     * Pre: name not empty, address not empty, city not empty, country not empty, phone not empty, email not empty.
     */
    public static void updateParticipant(Participant participant, String name, String address, String city, String country, String phone, String email, String company, String companyPhone) {
        participant.setName(name);
        participant.setAddress(address);
        participant.setCity(city);
        participant.setCountry(country);
        participant.setPhone(phone);
        participant.setEmail(email);
        participant.setCompany(company);
        participant.setCompanyPhone(companyPhone);
    }

    /**
     * Add a hotel to a conference
     * Pre: hotel does not already exist in conference hotels.
     */
    public static void addHotel(Conference conference, Hotel hotel) {
        conference.addHotel(hotel);
    }

    /**
     * Create an excursion in a conference
     * Pre: name not empty, date is between startDate and endDate, organizer not empty, price >= 0.0.
     */
    public static void createExcursion(Conference conference, String name, LocalDate date, double price) {
        conference.createExcursion(name, date, price);
    }

    /**
     * Create a registration to a conference
     * Note: nullable parameter companion, hotel
     * Pre: participant is not already registered, arrival is between startDate and endDate, departure is between arrival and endDate.
     */
    public static void createRegistration(Conference conference, Participant participant, boolean isSpeaker, LocalDate arrival, LocalDate departure, String companionName, Hotel hotel, ArrayList<Excursion> excursions, ArrayList<Utility> utilities) {
        conference.createRegistration(participant, isSpeaker, arrival, departure, companionName, hotel, excursions, utilities);
    }

    /**
     * Create a utility in a hotel
     * Pre: name is not empty, price >= 0.0.
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
            list.addAll(hotel.listHotel());
        }
        return list;
    }

}
