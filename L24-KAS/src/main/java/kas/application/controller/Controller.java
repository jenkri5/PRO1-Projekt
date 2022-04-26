package kas.application.controller;

import kas.application.model.*;
import kas.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

    public static Conference createConference(String name, double price, LocalDate startDate, LocalDate endDate) {
        Conference conference = new Conference(name, price, startDate, endDate);
        Storage.storeConference(conference);
        return conference;
    }

    public static ArrayList<Conference> getConferences() {
        return Storage.getConferences();
    }

    public static void deleteConference(Conference conference) {
        Storage.deleteConference(conference);
    }

    public static Hotel createHotel(String name, String address, String city, String country, double price, double priceTwo) {
        Hotel hotel = new Hotel(name, address, city, country, price, priceTwo);
        Storage.storeHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHotels() {
        return Storage.getHotels();
    }

    public static void deleteHotel(Hotel hotel) {
        Storage.deleteHotel(hotel);
    }

    public static Participant createParticipant(String name, String address, String city, String country, String phone, String email, String company, String companyPhone) {
        Participant participant = new Participant(name, address, city, country, phone, email, company, companyPhone);
        Storage.storeParticipant(participant);
        return participant;
    }

    public static ArrayList<Participant> getParticipants() {
        return Storage.getParticipants();
    }

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

    public static void deleteParticipant(Participant participant) {
        Storage.deleteParticipant(participant);
    }

    public ArrayList<String> getParticipantList(Conference conference) {
        ArrayList<String> participantList = new ArrayList<>();
        for (Registration registration : conference.getRegistrations())
            participantList.add(registration.getParticipant().getName());
        return participantList;
    }

    public ArrayList<String> getExcursionList(Conference conference) {
        ArrayList<String> excursionList = new ArrayList<>();
        return excursionList;
    }

    public ArrayList<String> getHotelList(Conference conference) {
        ArrayList<String> hotelList = new ArrayList<>();
        return hotelList;
    }

}
