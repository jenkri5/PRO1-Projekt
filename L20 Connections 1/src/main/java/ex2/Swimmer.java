package ex2;

import java.util.ArrayList;

public class Swimmer {

    private String name;
    private ArrayList<Double> lapTimes;

    public Swimmer(String name, ArrayList<Double> lapTimes) {
        this.name = name;
        this.lapTimes = lapTimes;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Double> getLapTimes() {
        return lapTimes;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double bestTime = 0;
        for (Double time : lapTimes) {
            bestTime = Math.max(bestTime, time);
        }
        return bestTime;
    }

}
