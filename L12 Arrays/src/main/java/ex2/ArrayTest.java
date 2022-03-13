package ex2;

public class ArrayTest {

    public static void main(String[] args) {
        int[] intArray = {4,6,7,2,3};
        double[] doubleArray = {3.14, 1.34, 4.31};
        System.out.println(sum(intArray));
        System.out.println(sum(doubleArray));
    }

    public static int sum(int[] t) {
        int sum = 0;
        for (int e : t) {
            sum += e;
        }
        return sum;
    }

    public static double sum(double[] t) {
        double sum = 0.0;
        for (double e : t) {
            sum += e;
        }
        return sum;
    }

}
