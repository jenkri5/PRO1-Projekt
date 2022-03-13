package random;

import java.util.Arrays;

public class FibonacciTester {

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        long[] numbers = fib.generateNumbers(50);
        System.out.println(Arrays.toString(numbers));
    }

}