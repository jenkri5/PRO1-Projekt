package ex2;

import java.util.ArrayList;
import java.util.List;

public class SwimmerApp {

    public static void main(String[] args) {
        TrainingPlan trainingPlanA = new TrainingPlan('A', 16, 10);
        TrainingPlan trainingPlanB = new TrainingPlan('B', 10, 6);

        ArrayList<Double> lapTimesJan = new ArrayList<>();
        lapTimesJan.addAll(List.of(1.02, 1.01, 0.99, 0.98, 1.02, 1.04, 0.99));

        Swimmer jan = new Swimmer("Jan", lapTimesJan);

        ArrayList<Double> lapTimesBo = new ArrayList<>();
        lapTimesBo.addAll(List.of(1.05, 1.01, 1.04, 1.06, 1.08, 1.04, 1.02));

        Swimmer bo = new Swimmer("Bo", lapTimesBo);

        ArrayList<Double> lapTimesMikkel = new ArrayList<>();
        lapTimesMikkel.addAll(List.of(1.03, 1.01, 1.02, 1.05, 1.03, 1.06, 1.03));

        Swimmer mikkel = new Swimmer("Mikkel", lapTimesMikkel);

        trainingPlanA.addSwimmer(jan);
        trainingPlanA.addSwimmer(bo);
        trainingPlanB.addSwimmer(mikkel);

        ArrayList<TrainingPlan> trainingPlans = new ArrayList<>();
        trainingPlans.add(trainingPlanA);
        trainingPlans.add(trainingPlanB);

        for (TrainingPlan t : trainingPlans) {
            for (Swimmer s : t.getSwimmers()) {
                System.out.println(s.getName() + "'s bedste tid: " + s.bestLapTime());
                System.out.println(s.getName() + "'s ugentlige træningstimer: " + t.allTrainingHours());
            }
        }
    }
}
