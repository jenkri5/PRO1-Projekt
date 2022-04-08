package ex2;

public class Test {

    public static void main(String[] args) {
        Rental r1 = new Rental(1, "1 april", 25);
        Rental r2 = new Rental(2, "25 may", 10);
        Rental r3 = new Rental(3,"1 july",5);

        Car c1 = new Car("123", "1991");
        c1.setPricePerDay(750);
        Car c2 = new Car("321", "1976");
        c2.setPricePerDay(500);
        Car c3 = new Car("42", "2002");
        c3.setPricePerDay(1000);

        r1.addCar(c1);
        r1.addCar(c2);
        r1.addCar(c3);

        r2.addCar(c1);

        r3.addCar(c3);

        System.out.println(c3.getMaxDays());
        System.out.println(r1.getPrice());


    }

}
