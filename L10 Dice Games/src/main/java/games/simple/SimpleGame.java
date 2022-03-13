package games.simple;

import games.DiceThrower;
import java.util.Scanner;

public class SimpleGame {

    /**
     * Simulates playing one game of Simple.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        DiceThrower thrower = new DiceThrower();

        boolean finished = false;
        while (!finished) {
            thrower.roll();
            System.out.println(thrower.rollDescription());

            System.out.println("Roll again? (Y/n) ");
            String answer = scanner.nextLine();
            if (answer.equalsIgnoreCase("n")) {
                finished = true;
            }
        }
        scanner.close();

        System.out.printf("\nResults:\n");
        System.out.printf("---------\n");
        // roll count, total of all face values, average sum in one roll,
        // count of face value 6, count of same face value on both dice,
        // max sum in one roll.
        // Use the method: System.out.printf().
        System.out.printf("Roll count: %d\n", thrower.getRollCount());
        System.out.printf("Total of all face values: %d\n", thrower.getTotalValue());
        System.out.printf("Average sum in one roll: %.2f\n", (double)thrower.getTotalValue()/thrower.getRollCount());
        System.out.printf("Count of face value 6: %d\n", thrower.getSixCount());
        System.out.printf("Count of same face value on both dice: %d\n", thrower.getSameFaceCount());
        System.out.printf("Max sum in one roll: %d\n", thrower.getBiggestRoll());


    }

    /**
     * Prints the rules of Simple.
     */
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Simple:");
        System.out.println("The player throws the 2 dice as long as he/she wants.");
        System.out.println("=====================================================");
    }

}
