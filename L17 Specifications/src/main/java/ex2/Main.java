package ex2;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        Rental r1 = new Rental(1, 10, 3000, now.plusMonths(10));
        Rental r2 = new Rental(2, 30, 1750, LocalDate.of(now.getYear(), now.getMonth().plus(1), 1));

        System.out.println(r1.getStartDate() + " || " + r1.getEndDate());
        System.out.println(r2.getStartDate() + " || " + r2.getEndDate());

        r2.setDays(10);
        System.out.println(r2.getStartDate() + " || " + r2.getEndDate());

        System.out.println(r1.getTotalPrice());
    }
}
