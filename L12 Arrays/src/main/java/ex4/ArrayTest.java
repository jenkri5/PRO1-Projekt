package ex4;

public class ArrayTest {

    public static void main(String[] args) {
        int[] intArray1 = {4,6,7,2,3};
        int[] intArray2 = {4,6,8,2,6};

        System.out.println(hasUneven(intArray1));
        System.out.println(hasUneven(intArray2));
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

    public static boolean hasUneven(int[] t) {
        for (int i : t) {
            if (i%2 != 0)
                return true;
        }
        return false;
    }

}
