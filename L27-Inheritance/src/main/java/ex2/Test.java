package ex2;

import java.time.Year;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<Mechanic> mechanics = new ArrayList<>();

        Mechanic m1 = new Mechanic("Bob", "Vej 1", Year.of(2022), 150);
        mechanics.add(m1);
        Mechanic m2 = new Mechanic("Sussi", "Vej 2", Year.of(2019), 160);
        mechanics.add(m2);
        Mechanic m3 = new Mechanic("Lars", "Vej 3", Year.of(1998), 200);
        mechanics.add(m3);
        Foreman f1 = new Foreman("Anders", "Vej 4", Year.of(1988), 250, Year.of(1995), 500);
        mechanics.add(f1);
        Foreman f2 = new Foreman("Børge", "Vej 5", Year.of(1985), 260, Year.of(1993), 600);
        mechanics.add(f2);
        Foreman f3 = new Foreman("Peter", "Vej 6", Year.of(1979), 300, Year.of(1985), 1000);
        mechanics.add(f3);
        Survoyer s1 = new Survoyer("Birthe", "Vej 7", Year.of(2012), 230);
        s1.performInspection();
        s1.performInspection();
        mechanics.add(s1);

        for (Mechanic mechanic : mechanics)
            System.out.println("name: " + mechanic.getName() + " salary: " + mechanic.weeklySalary());
        System.out.println("total salary: " + totalWeeklySalary(mechanics));

    }

    public static double totalWeeklySalary(ArrayList<Mechanic> mechanics) {
        double totalSalary = 0.0;
        for (Mechanic mechanic : mechanics)
            totalSalary += mechanic.weeklySalary();
        return totalSalary;
    }

}
