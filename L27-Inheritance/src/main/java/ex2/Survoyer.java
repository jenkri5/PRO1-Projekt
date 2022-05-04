package ex2;

import java.time.Year;

public class Survoyer extends Mechanic {

    private int inspection = 0;
    private final int PREMIUM = 29;

    public Survoyer(String name, String address, Year apprenticeship, int wage) {
        super(name, address, apprenticeship, wage);
    }

    public void performInspection() {
        inspection++;
    }

    @Override
    public double weeklySalary() {
        return super.weeklySalary() + (inspection * PREMIUM);
    }
}
