package magicsquare;

import java.util.Scanner;

public class MagicSquare {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[][] magicsquare;
        int row, column;

        System.out.print("Type an odd number: ");
        int n = scanner.nextInt();
        magicsquare = new int[n][n];
        row = n - 1;
        column = n / 2;

        try {
            for (int k = 1; k <= n * n; k++) {
                magicsquare[row][column] = k;
                row++;
                column++;
                if (row == n)
                    row = 0;
                if (column == n)
                    column = 0;
                if (magicsquare[row][column] != 0) {
                    if (row == 0)
                        row = n - 1;
                    else
                        row--;
                    if (column == 0)
                        column = n - 1;
                    else
                        column--;
                    row--;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println(e);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magicsquare[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();

    }
}
