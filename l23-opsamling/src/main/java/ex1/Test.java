package ex1;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Dog> dogs = new ArrayList<>();
        Dog d1 = new Dog("Buller", false, 150, Race.PUDDEL);
        dogs.add(d1);
        Dog d2 = new Dog("Pepsi", true, 500, Race.PUDDEL);
        dogs.add(d2);
        Dog d3 = new Dog("K-9", false, 200, Race.TERRIER);
        dogs.add(d3);
        Dog d4 = new Dog("Baileys", true, 150, Race.BOKSER);
        dogs.add(d4);
        Dog d5 = new Dog("MissingNO", true, 750, Race.PUDDEL);
        dogs.add(d5);

        System.out.println("Total price of puddels: " + totalPrice(dogs, Race.PUDDEL));
    }

    public static int totalPrice(ArrayList<Dog> dogs, Race race) {
        int totalPrice = 0;
        for (Dog dog : dogs)
            if (dog.getRace() == race)
                totalPrice += dog.getPrice();
        return totalPrice;
    }

}
