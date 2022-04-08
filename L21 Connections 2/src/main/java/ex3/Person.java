package ex3;

import java.util.ArrayList;

public class Person {

    final String name;
    int age;
    ArrayList<Gift> gifts = new ArrayList<>();

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int totalPrice() {
        int price = 0;
        for (Gift gift : gifts)
            price += gift.price;
        return price;
    }

    public ArrayList<Person> getGivers() {
        ArrayList<Person> givers = new ArrayList<>();
        for (Gift gift : gifts)
            givers.add(gift.giver);
        return givers;
    }
}
