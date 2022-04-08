package ex3;

public class Test {

    public static void main(String[] args) {
        Car car1 = new Car("17234891", "1974");
        Car car2 = new Car("28371391", "2002");

        car1.setPricePerDay(500);
        car2.setPricePerDay(1000);

        Rental rental1 = new Rental(5, "1 April 2022", 10);

        rental1.addCar(car1);
        rental1.addCar(car2);

        System.out.println("Price of rental: " + rental1.getPrice());

    }

}
