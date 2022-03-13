package games.pig;

import java.util.Scanner;

public class PigApp {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Pig.");
        PigGame game = new PigGame(scanner, 8, 25, 1000);
        game.initialize();
        System.out.println("Thank you for playing pig.");
        scanner.close();
    }
}
