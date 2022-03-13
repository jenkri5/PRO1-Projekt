package ex4;

import java.util.Scanner;

public class Ex4App {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input, length, count = 0, sum = 0;
        System.out.print("Input a number: ");
        input = scanner.nextInt();
        length = String.valueOf(input).length();
        while(count < length) {
            char c = String.valueOf(input).charAt(count);
            int n = c - '0';
            if(n%2 == 1) {
                sum = sum + n;
            }
            count++;
        }
        System.out.println("The sum of all odd digits of input: " + sum);
        scanner.close();
    }
}
