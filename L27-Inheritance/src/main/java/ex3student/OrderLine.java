package ex3student;

public class OrderLine {
    private final int lineNumber;
    private final int count;

    // association 0..* --> 1 Product
    private final Product product;

    OrderLine(int lineNumber, int count, Product product) { // OBS: package visible
        this.lineNumber = lineNumber;
        this.count = count;
        this.product = product;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getCount() {
        return this.count;
    }

    public Product getProduct() {
        return product;
    }
}
