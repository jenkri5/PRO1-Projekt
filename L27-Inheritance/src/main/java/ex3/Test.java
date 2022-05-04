package ex3;

import java.time.LocalDate;

public class Test {

    public static void main(String[] args) {
        Product p1 = new Product(1, "Product 1", 10.0);
        Product p2 = new Product(2, "Product 2", 20.0);
        Product p3 = new Product(3, "Product 3", 30.0);
        Product p4 = new Product(4, "Product 4", 40.0);
        Product p5 = new Product(5, "Product 5", 50.0);

        Customer c1 = new Customer("Customer 1", LocalDate.of(1988, 4, 29));
        Customer c2 = new Customer("Customer 2", LocalDate.of(2002, 1, 16));

        Order o1 = new Order(1);
        o1.createOrderLine(1, p1);
        o1.createOrderLine(2, p2);
        Order o2 = new Order(2);
        o2.createOrderLine(3, p3);
        o2.createOrderLine(4, p4);
        Order o3 = new Order(3);
        o3.createOrderLine(5, p5);
        o3.createOrderLine(1, p1);
        Order o4 = new Order(4);
        o4.createOrderLine(2, p2);
        o4.createOrderLine(3, p3);
        Order o5 = new Order(5);
        o5.createOrderLine(4, p4);
        o5.createOrderLine(5, p5);
        Order o6 = new Order(6);
        o6.createOrderLine(1, p1);
        o6.createOrderLine(2, p2);
        o6.createOrderLine(3, p3);
        o6.createOrderLine(4, p4);
        o6.createOrderLine(5, p5);

        c1.addOrder(o1);
        c1.addOrder(o2);
        c2.addOrder(o3);
        c2.addOrder(o4);
        c2.addOrder(o5);
        c2.addOrder(o6);

        PercentDiscount d1 = new PercentDiscount(15);
        FixedDiscount d2 = new FixedDiscount(250, 1000);

        c1.setDiscount(d1);
        c2.setDiscount(d2);

        System.out.println(c1.totalBuy());
        System.out.println(c1.totalBuyWithDiscount());
        System.out.println(c2.totalBuy());
        System.out.println(c2.totalBuyWithDiscount());
    }

}
