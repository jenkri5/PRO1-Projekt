package games.craps;

import games.DiceThrower;

import java.util.Scanner;

public class CrapsGame {

    private final Scanner scanner = new Scanner(System.in);
    private final DiceThrower thrower = new DiceThrower();
    private int games, wonGames, firstRollWins, target;
    private boolean finished, firstRound;

    /**
     * Play craps.
     */
    public void play() {
        finished = false;
        firstRound = true;
        while (!finished) {
            thrower.roll();
            System.out.println("You rolled: " + thrower.sum());
            if (firstRound) {
                target = thrower.sum();
                if (thrower.sum() == 7 || thrower.sum() == 11) {
                    printGameWon();
                    firstRollWins++;
                    playAgain();
                } else if (thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12) {
                    printGameLost();
                    playAgain();
                } else {
                    firstRound = false;
                }
            } else {
                if (thrower.sum() == target) {
                    printGameWon();
                    playAgain();
                } else if (thrower.sum() == 7) {
                    printGameLost();
                    playAgain();
                }
            }
        }
        scanner.close();
    }

    /**
     * Simulate a lot of games of craps.
     */
    public void runSimulation(int scope) {
        firstRound = true;
        for (int i = 0; i < scope; i++) {
            if (firstRound) {
                thrower.roll();
                target = thrower.sum();
                if (thrower.sum() == 7 || thrower.sum() == 11) {
                    games++;
                    wonGames++;
                    firstRollWins++;
                    firstRound = true;
                    target = 0;
                } else if (thrower.sum() == 2 || thrower.sum() == 3 || thrower.sum() == 12) {
                    games++;
                    firstRound = true;
                    target = 0;
                } else {
                    thrower.roll();
                    firstRound = false;
                }
            }

            while (target > 0) {
                if (thrower.sum() == target) {
                    games++;
                    wonGames++;
                    firstRound = true;
                    target = 0;
                } else if (thrower.sum() == 7) {
                    games++;
                    firstRound = true;
                    target = 0;
                }
                else {
                    thrower.roll();
                }
            }
        }
        printStats();
        scanner.close();
    }

    /**
     * Choose to play again.
     */
    public void playAgain() {
        System.out.println("Play again? (Y/n) ");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("n")) {
            printStats();
            finished = true;
        }
        firstRound = true;
        target = 0;
    }

    /**
     * Prints a 'You have won' message.
     */
    public void printGameWon() {
        games++;
        wonGames++;
        System.out.println("You have won");
        System.out.println();
    }

    /**
     * Prints a 'You have lost' message.
     */
    public void printGameLost() {
        games++;
        System.out.println("You have lost");
        System.out.println();
    }

    /**
     * Prints the rules of craps.
     */
    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Craps:");
        System.out.println("In the game a player throws 2 dice. The first throw is called 'the come out roll'.");
        System.out.println("The player wins, if the sum of the dice in the come out roll is 7 or 11.");
        System.out.println("The player loses, if the sum is 2, 3 or 12.");
        System.out.println("If the sum is something else (that is, 4, 5, 6, 8, 9 or 10), the sum is set as the player's 'point'.");
        System.out.println("The player will now continue throwing the dice until he has lost or won.");
        System.out.println("A sum equal his 'point' is a win, and a sum equal 7 is a loss.");
        System.out.println("=====================================================");
    }

    /**
     * Prints the stats of craps.
     */
    public void printStats() {
        System.out.println("=====================================================");
        System.out.println("You played " + games + " games");
        System.out.println("You won " + wonGames + " games, " + firstRollWins + " of which was first turn wins");
        System.out.printf("You rolled an average of %.2f times per game\n",(double) thrower.getRollCount() / games);
        System.out.println("=====================================================");
    }
}
