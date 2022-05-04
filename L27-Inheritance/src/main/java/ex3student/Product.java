package ex3student;

public class Product {
    private final int number;
    private String name;
    private double unitPrice;

    public Product(int number, String name, double unitPrice) {
        this.number = number;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
