package ex2;

import java.time.LocalDate;
import java.time.Period;

public class Rental {

    int number;
    Period days;
    LocalDate startDate;
    double price;

    /**
     * Constructor for Rental class
     * Sets local member variables
     * Converts days to Period
     * @param number
     * @param days
     * @param price
     * @param startDate
     */
    Rental(int number, int days, double price, LocalDate startDate) {
        this.number = number;
        this.days = Period.ofDays(days);
        this.price = price;
        this.startDate = startDate;
    }

    /**
     * Returns the price of the rental
     * @return price
     */
    double getPricePrDay() {
        return price;
    }

    /**
     * Sets the rental period in days
     * Takes an int and converts to Period
     * @param days
     */
    void setDays(int days) {
        this.days = Period.ofDays(days);
    }

    /**
     * Returns the rental period in days as an int
     * @return days.getDays()
     */
    int getDays() {
        return days.getDays();
    }

    /**
     * Returns the start date as LocalDate object
     * @return startDate
     */
    LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Returns the end date as LocalDate object
     * @return startDate.plus(days)
     */
    LocalDate getEndDate() {
        return startDate.plus(days);
    }

    /**
     * Returns the total price of the rental
     * @return price * days.getDays()
     */
    double getTotalPrice() {
        return price * days.getDays();
    }
}
