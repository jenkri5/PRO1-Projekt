package ex1;

import java.time.Year;

public class Mechanic extends Person {

    private final Year apprenticeship;
    private final int wage;

    public Mechanic(String name, String address, Year apprenticeship, int wage) {
        super(name, address);
        this.apprenticeship = apprenticeship;
        this.wage = wage;
    }

    public Year getApprenticeship() {
        return apprenticeship;
    }

    public int getWage() {
        return wage;
    }

}
