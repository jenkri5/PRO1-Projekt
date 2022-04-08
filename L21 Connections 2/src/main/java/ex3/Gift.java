package ex3;

public class Gift {

    final String description;
    int price;
    Person giver, receiver;

    public Gift(String description, int price, Person giver) {
        this.description = description;
        this.price = price;
        this.giver = giver;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
        receiver.gifts.add(this);
    }
}
