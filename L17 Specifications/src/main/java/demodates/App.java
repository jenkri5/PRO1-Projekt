package demodates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class App {

	public static void main(String[] args) {
		LocalDate d1 = LocalDate.of(2014, 6, 3);
		System.out.println(d1);
		LocalDate d2 = LocalDate.of(2016, Month.OCTOBER, 1);
		System.out.println(d2);
		System.out.println();

		LocalDate d3 = d2.plusMonths(1).plusDays(70);
		System.out.println(d3);
		System.out.println();

		Period per = d1.until(d2);
		System.out.println("Period: " + per);
		System.out.printf("From %s to %s: %d years, %d months, %d days\n",
				d1, d2, per.getYears(), per.getMonths(), per.getDays());
		System.out.println();

		long months = d1.until(d2, ChronoUnit.MONTHS);
		System.out.printf("From %s to %s: %d months\n", d1, d2, months);
		long days = d1.until(d2, ChronoUnit.DAYS);
		System.out.printf("From %s to %s: %d days\n", d1, d2, days);
		System.out.println();

		LocalTime t1 = LocalTime.of(0, 0, 10);
		System.out.println(t1);
		LocalTime t2 = t1.plusHours(1).plusMinutes(1).plusSeconds(1);
		System.out.println(t2);
		System.out.println();

		Long seconds = t1.until(t2, ChronoUnit.SECONDS);
		System.out.printf("From %s to %s: %d seconds\n", t1, t2, seconds);
		System.out.println();

		LocalDateTime dt1 = LocalDateTime.of(2014, 7, 25, 0, 0, 10);
		System.out.println(dt1);
		LocalDateTime dt2 = dt1.plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
		System.out.println(dt2);
		System.out.println();

		Long seconds1 = dt1.until(dt2, ChronoUnit.SECONDS);
		System.out.printf("From %1$s to %2$s: %3$d seconds\n", dt1, dt2, seconds1);
		System.out.printf("From %1$tF at %1$tT to %2$tF at %2$tT: %3$d seconds\n",
				dt1, dt2, seconds1);
		// JavaDoc for the FORMATTER class has a long description af all the possible format specifiers.
	}

}
