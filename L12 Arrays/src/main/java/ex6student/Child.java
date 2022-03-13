package ex6student;

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
}
