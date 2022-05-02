package kas.application.model;

import java.util.ArrayList;

public class Participant {

    private String name;
    private String address;
    private String city;
    private String country;
    private String phone;
    private String email;
    private String company; // nullable
    private String companyPhone; // nullable
    final ArrayList<Registration> registrations = new ArrayList<>(); // association 1 --> 0..* Registration
    final ArrayList<Conference> conferences = new ArrayList<>(); // association 0..* --> 0..* Conference

    /**
     * Note: nullable parameter company, companyPhone
     * Pre: name not empty, address not empty, city not empty, country not empty, phone not empty, email not empty. */
    public Participant(String name, String address, String city, String country, String phone, String email, String company, String companyPhone) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.company = company;
        this.companyPhone = companyPhone;
    }

    public String getName() {
        return name;
    }

    /** Pre: name not empty. */
    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    /** Pre: address not empty. */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    /** Pre: city not empty. */
    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    /** Pre: country not empty. */
    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    /** Pre: phone not empty. */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    /** Pre: email not empty. */
    public void setEmail(String email) {
        this.email = email;
    }

    /** Note: Nullable return value. */
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    /** Note: Nullable return value. */
    public String getCompanyPhone() {
        return companyPhone;
    }

    public void setCompanyPhone(String companyPhone) {
        this.companyPhone = companyPhone;
    }

    public ArrayList<Registration> getRegistrations() {
        return new ArrayList<>(registrations);
    }

    public ArrayList<Conference> getConferences() {
        return new ArrayList<>(conferences);
    }

    @Override
    public String toString() {
        return name;
    }
}
