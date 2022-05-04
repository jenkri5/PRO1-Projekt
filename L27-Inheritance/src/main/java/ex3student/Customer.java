package ex3student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private final LocalDate birthday;

    // association 1 --> 0..* Order
    private final ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return this.birthday;
    }

    public List<Order> getOrders() {
        return new ArrayList<Order>(orders);
    }

    /** Pre: The order is not connected to a customer. */
    public void addOrder(Order order) {
        orders.add(order);
    }

    /** Pre: The order is connected to this customer. */
    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
