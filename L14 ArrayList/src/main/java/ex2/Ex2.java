package ex2;

import java.util.ArrayList;

public class Ex2 {

    /**
     * Tests all the methods.
     */
    public static void main(String[] args) {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(12);
        ints.add(0);
        ints.add(45);
        ints.add(7);
        ints.add(-16);
        ints.add(0);
        ints.add(23);
        ints.add(-10);
//        ints.addAll(List.of(12, 0, 45, 7, -16, 0, 23, -10));
        System.out.println("ints: " + ints);
        System.out.println();

        // Test of sum1() method: correct sum is 61.
        int total = sum1(ints);
        System.out.println("Sum: " + total);

        // Test of sum() method: correct sum is 61.
        int total2 = sum(ints);
        System.out.println("Sum: " + total2);

        // Test of minimum() method: correct minimum is -16.
        int minimum = minimum(ints);
        System.out.println("Minimum: " + minimum);

        // Test of maximum() method: correct maximum is 45.
        int maximum = maximum(ints);
        System.out.println("Maximum: " + maximum);

        // Test of average() method: correct average is 7.625.
        double average = average(ints);
        System.out.println("Average: " + average);

        // Test of zeroes() method: correct number of zeroes is 2.
        int zeroes = zeroes(ints);
        System.out.println("Zeroes: " + zeroes);

        // Test of evens() method: correct result is [12, 0, -16, 0, -10].
        ArrayList<Integer> evens = evens(ints);
        System.out.println("Evens: " + evens);
    }

    // sum made with for statement
    public static int sum1(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int number = list.get(i);
            sum += number;
        }
        return sum;
    }

    /**
     * Return the sum of all numbers in the list.
     * Return 0, if the list is empty.
     */
    public static int sum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i : list)
            sum += i;
        return sum;
    }

    /**
     * Return the minimum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int minimum(ArrayList<Integer> list) {
        int minimum = Integer.MAX_VALUE;
        for (int i : list)
            if (i  < minimum)
                minimum = i;
        return minimum;
    }

    /**
     * Return the maximum of all numbers in the list.
     * Pre: The list is not empty.
     */
    public static int maximum(ArrayList<Integer> list) {
        int maximum = Integer.MIN_VALUE;
        for (int i : list)
            if (i  > maximum)
                maximum = i;
        return maximum;
    }

    /**
     * Return the average of the numbers in the list.
     * Pre: The list is not empty.
     */
    public static double average(ArrayList<Integer> list) {
        return (double) sum(list) / list.size();
    }

    /** Return the number of zeros in the list. */
    public static int zeroes(ArrayList<Integer> list) {
        int count = 0;
        for (int i : list)
            if (i == 0)
                count++;
        return count;
    }

    /** Return a new list containing the even numbers in the list. */
    public static ArrayList<Integer> evens(ArrayList<Integer> list) {
        ArrayList<Integer> evens = new ArrayList<>();
        for (int i : list)
            if (i%2 == 0)
                evens.add(i);
        return evens;
    }
}
