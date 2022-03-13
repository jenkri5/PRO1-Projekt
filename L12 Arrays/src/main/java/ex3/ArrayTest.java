package ex3;

import java.util.Arrays;

public class ArrayTest {

    public static void main(String[] args) {
        int[] intArray1 = {4,6,7,2,3};
        int[] intArray2 = {4,6,8,2,6,2,3};
        double[] doubleArray = {3.14, 1.34, 4.31};
        System.out.println(sum(intArray1));
        System.out.println(sum(doubleArray));
        System.out.println(Arrays.toString(sumArrays2(intArray1, intArray2)));
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

    public static int[] sumArrays(int[] a, int[] b) {
        int[] sum = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            sum[i] = a[i]+b[i];
        }
        return sum;
    }

    public static int[] sumArrays2(int[] a, int[] b) {
        int[] sum = new int[Math.max(a.length, b.length)];
        for (int i = 0; i < sum.length; i++) {
            if (i < Math.min(a.length, b.length))
                sum[i] = a[i]+b[i];
            else if (a.length > b.length)
                sum[i] = a[i];
            else
                sum[i] = b[i];
        }
        return sum;
    }

}
