package ex1;

public class Dog {

    private String name;
    private final boolean ahnentafel;
    private int price;
    private final Race race;

    public Dog(String name, boolean ahnentafel, int price, Race race) {
        this.name = name;
        this.ahnentafel = ahnentafel;
        this.price = price;
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAhnentafel() {
        return ahnentafel;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Race getRace() {
        return race;
    }

}
