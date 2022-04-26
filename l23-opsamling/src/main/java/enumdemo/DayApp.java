package enumdemo;

import java.util.Arrays;
import java.util.Random;

public class DayApp {

    public enum Day {
        MANDAG, TIRSDAG, ONSDAG, TORSDAG, FREDAG, LOERDAG, SOENDAG
    }

    public static void main(String[] args) {
        Random r = new Random();
        int no = r.nextInt(7);
        Day day = Day.values()[no];
        Day saturday = Day.LOERDAG;
        System.out.println("day: " + day); // from enum to String
        System.out.println("saturday: " + saturday);
        System.out.println();

        System.out.println("Dage: " + Arrays.toString(Day.values()));
        System.out.println();

        System.out.println("Ordinal værdien for " + day + ": " + day.ordinal());
        System.out.println("Ordinal værdien for " + saturday + ": " + saturday.ordinal());
        System.out.println();

        if (day == Day.LOERDAG)
            System.out.println("Den tilfældige dag er lørdag");
        else
            System.out.println("Den tilfældige dag er ikke lørdag");
        System.out.println();

        String str = Day.ONSDAG.toString(); // from enum value to String
        System.out.println(str);
        Day day1 = Day.valueOf("ONSDAG"); // from String to enum value
        System.out.println(day1);
    }
}
