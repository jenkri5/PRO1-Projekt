package ex1;

import java.util.Scanner;

public class E51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scanner.nextInt();
        if (input > 0) {
            System.out.println("The number is positive.");
        } else if (input == 0) {
            System.out.println("The number is zero.");
        } else {
            System.out.println("The number is negative.");
        }
        scanner.close();
    }

}
