package ex1;

public class Dog {

    private final int number;
    private String name;
    Person person;

    public Dog(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "number=" + number +
                ", name='" + name + '\'' +
                '}';
    }

}
