package ex3;

public class FixedDiscount extends Discount {

    private final int fixedDiscount;
    private final int discountLimit;

    /** Pre: fixedDiscount <= discountLimit */
    public FixedDiscount(int fixedDiscount, int discountLimit) {
        this.fixedDiscount = fixedDiscount;
        this.discountLimit = discountLimit;
    }

    @Override
    public double getDiscount(double price) {
        if (price >= discountLimit)
            return price - fixedDiscount;
        else
            return price;
    }

}
