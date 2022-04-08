package ex1.d;

import java.util.ArrayList;

public class Person {

    private String name;
    private final String cpr;
    private String phone;
    ArrayList<Dog> dogs = new ArrayList<>();

    public Person(String name, String cpr, String phone) {
        this.name = name;
        this.cpr = cpr;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ArrayList<Dog> getDogs() {
        return dogs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

}
