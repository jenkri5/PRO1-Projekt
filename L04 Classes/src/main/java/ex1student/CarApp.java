package ex1student;

public class CarApp {

    public static void main(String[] args) {
        Car myCar = new Car("VW UP", "White", "AB 12.345");
        System.out.println(myCar.getBrand() + ", " + myCar.getColor());
        System.out.println(myCar.getKm());
        System.out.println();

        myCar.setKm(5000);
        System.out.println(myCar.getKm());
    }
}
