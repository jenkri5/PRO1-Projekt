package ex3;

import java.util.Scanner;

public class Ex3App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a, b, min, max, sum = 0;
        System.out.print("Input a number: ");
        a = scanner.nextInt();
        System.out.print("Input another number: ");
        b = scanner.nextInt();
        min = Math.min(a, b);
        max = Math.max(a, b);
        while(min <= max) {
            if(min%2 == 1)
                sum = sum + min;
            min++;
        }
        System.out.println("The sum of all odd numbers between a and b (inclusive): " + sum);
        scanner.close();
    }
}
