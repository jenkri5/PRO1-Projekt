package ex1student;

public class Car {
    private final String brand;
    private final String color;
    private final String registrationNumber;
    private int km;

    public Car(String brand, String color, String registrationNumber) {
        this.brand = brand;
        this.color = color;
        this.registrationNumber = registrationNumber;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public String getColor() {
        return this.color;
    }

    public int getKm() {
        return this.km;
    }

    public void setKm(int km) {
        this.km = km;
    }
}
