package random;

public class Fibonacci {

    private long t1=0, t2=1, nextT=t1+t2;

    public long[] generateNumbers(int n) {
        long[] numbers = new long[n];
        for(int i=0;i<n;i++) {
            numbers[i] = t1;
            t1 = t2;
            t2 = nextT;
            nextT = t1+t2;
        }
        return numbers;
    }

}