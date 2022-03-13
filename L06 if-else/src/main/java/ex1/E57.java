package ex1;

import java.util.Scanner;

public class E57 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 3 numbers: ");
        int int1 = scanner.nextInt();
        int int2 = scanner.nextInt();
        int int3 = scanner.nextInt();

        if (int1<int2 && int2<int3) {
            System.out.println("Increasing");
        } else if (int1>int2 && int2>int3) {
            System.out.println("Decreasing");
        } else {
            System.out.println("Neither");
        }
        scanner.close();
    }

}
