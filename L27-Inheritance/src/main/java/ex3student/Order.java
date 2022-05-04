package ex3student;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int number;

    // composition 1 --> 0..* OrderLine
    private final List<OrderLine> orderLines = new ArrayList<>();

    public Order(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    public ArrayList<OrderLine> getOrderLines() {
        return new ArrayList<>(orderLines);
    }

    public OrderLine createOrderLine(int count, Product product) {
        OrderLine line = new OrderLine(orderLines.size() + 1, count, product);
        orderLines.add(line);
        return line;
    }
}
