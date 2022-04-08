package ex3;

import java.util.ArrayList;

public class Car {

    private final String no;
    private final String year;
    private int pricePerDay;

    public Car(String no, String year) {
        this.no = no;
        this.year = year;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public String getNo() {
        return no;
    }

    public String getYear() {
        return year;
    }

}
