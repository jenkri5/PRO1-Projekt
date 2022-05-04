package ex2;

import java.time.Year;

public class Foreman extends Mechanic {

    private final Year promotion;
    private final int premium;

    public Foreman(String name, String address, Year apprenticeship, int wage, Year promotion, int premium) {
        super(name, address, apprenticeship, wage);
        this.promotion = promotion;
        this.premium = premium;
    }

    public Year getPromotion() {
        return promotion;
    }

    public int getPremium() {
        return premium;
    }

    @Override
    public double weeklySalary() {
        return super.weeklySalary() + premium;
    }

    
}
