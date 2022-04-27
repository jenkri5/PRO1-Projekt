package kas.application.controller;

import kas.application.model.*;
import kas.storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Controller {

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
