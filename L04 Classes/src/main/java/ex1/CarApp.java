package ex1;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("Ferrari", "Red", "CD 67.890");
        myCar.setKm(420);
        System.out.println(myCar.getBrand() + ", " + myCar.getColor());
        System.out.println(myCar.getRegistrationNumber());
        System.out.println(myCar.getKm());
    }
}
