package ex3;

public class PercentDiscount extends Discount {

    private final int discountPercentage;

    /** Pre: 0 <= discountPercentage <= 100 */
    public PercentDiscount(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getDiscount(double price) {
        return price - (price * ((double) discountPercentage / 100));
    }

}
