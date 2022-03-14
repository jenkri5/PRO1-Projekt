package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveTester {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecursiveMath recursiveMath = new RecursiveMath();

        System.out.print("Type a number: ");
        int n = scanner.nextInt();

        System.out.println("Factorial of "+n+" is: "+recursiveMath.factorial(n));


        scanner.close();
    }

}
