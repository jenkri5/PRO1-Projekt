package kas.application.model;

public class Participant {

    private final String name;
    private final String address;
    private final String city;
    private final String country;
    private final int phone;
    private final String email;
    private final String company;
    private final int companyPhone;

    public Participant(String name, String address, String city, String country, int phone, String email, String company, int companyPhone) {
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

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCompany() {
        return company;
    }

    public int getCompanyPhone() {
        return companyPhone;
    }

}
