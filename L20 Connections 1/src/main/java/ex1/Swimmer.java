package ex1;

import java.util.ArrayList;

public class Swimmer {

    private String name;
    private ArrayList<Double> lapTimes;
    private TrainingPlan trainingPlan;

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

    public TrainingPlan getTrainingPlan() {
        return trainingPlan;
    }

    public void setTrainingPlan(TrainingPlan trainingPlan) {
        this.trainingPlan = trainingPlan;
    }

    public void removeTrainingPlan() {
        trainingPlan = null;
    }

    /** Return the fastest lap time. */
    public double bestLapTime() {
        double bestTime = 0;
        for (Double time : lapTimes) {
            bestTime = Math.max(bestTime, time);
        }
        return bestTime;
    }

    public int allTrainingHours() {
        return trainingPlan.getWeeklyStrengthHours() + trainingPlan.getWeeklyWaterHours();
    }
}
