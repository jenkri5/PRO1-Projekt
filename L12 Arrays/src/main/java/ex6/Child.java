package ex6;

public class Child {
    private final String name;
    private final double[] weights;// can contain weights for the first 11 years
    private int weightsCount;

    public Child(String name) {
        this.name = name;
        this.weights = new double[11];
        this.weightsCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public double[] getWeights() {
        return this.weights;
    }

    public int getWeightsCount() {
        return this.weightsCount;
    }

    public double getWeight(int i) {
        return weights[i-1];
    }

    public void addWeight(double weight) {
        weights[weightsCount] = weight;
        weightsCount++;
    }

    public double maxYearlyWeightGain() {
        double res = 0.0;
        for(int i = 1; i < weightsCount; i++) {
            res = Math.max(res, weights[i]-weights[i-1]);
        }
        return res;
    }
}
