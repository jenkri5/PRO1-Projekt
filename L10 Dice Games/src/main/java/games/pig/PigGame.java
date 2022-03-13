package games.pig;

import java.util.Scanner;
import games.DiceThrower;

public class PigGame {

    private final Scanner scanner;
    private Player[] players;
    private final DiceThrower diceThrower = new DiceThrower();
    private final int maxPlayers, lowerLimit, upperLimit;
    private int points = 0, endGoal = 0, playerTurnPointer = 0, numberOfPlayers = -1, numberOfAIs = -1;

    public PigGame(Scanner scanner) {
        this.scanner = scanner;
        maxPlayers = 2;
        lowerLimit = 50;
        upperLimit = 100;
    }

    public PigGame(Scanner scanner, int maxPlayers, int lowerLimit, int upperLimit) {
        this.scanner = scanner;
        this.maxPlayers = maxPlayers;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    public void initialize() {
        printRules();
        setNumberOfPlayers();
        setNumberOfAIs();
        populatePlayers();
        setEndGoal();
        System.out.println("=====================================================");
        play();
    }

    public void play() {
        boolean finished = false;
        while (!finished) {
            diceThrower.roll();
            points += diceThrower.sum();
            players[playerTurnPointer].incrementThrowCount();
            players[playerTurnPointer].updateTotalValue(diceThrower.sum());
            System.out.printf("%s(%d) rolled %d (%d,%d)\n",
                    players[playerTurnPointer].getName(),
                    players[playerTurnPointer].getTotalPoints(),
                    diceThrower.sum(), diceThrower.getDie1FaceValue(),
                    diceThrower.getDie2FaceValue());
            if (diceThrower.getDie1FaceValue() == 1 && diceThrower.getDie2FaceValue() == 1) {
                players[playerTurnPointer].setTotalPoints(0);
                points = 0;
                System.out.printf("%s busted AND lost his points!\n" +
                        "=====================================================\n",
                        players[playerTurnPointer].getName());
                players[playerTurnPointer].incrementTurnCount();
                incrementPlayerTurnPointer();
            } else if (diceThrower.getDie1FaceValue() == 1 || diceThrower.getDie2FaceValue() == 1) {
                points = 0;
                System.out.printf("%s busted!\n" +
                        "=====================================================\n",
                        players[playerTurnPointer].getName());
                players[playerTurnPointer].incrementTurnCount();
                incrementPlayerTurnPointer();
            } else if (diceThrower.getDie1FaceValue() != diceThrower.getDie2FaceValue()) {
                boolean isHumanPlayer = playerTurnPointer < numberOfPlayers;
                if (isHumanPlayer) {
                    if (points + players[playerTurnPointer].getTotalPoints() > endGoal) {
                        players[playerTurnPointer].updateTotalPoints(points);
                        players[playerTurnPointer].incrementTurnCount();
                        printVictory();
                        finished = true;
                    } else {
                        System.out.printf("Current points: %d\n" +
                                "You need %d more points\n",
                                points, endGoal-(points+players[playerTurnPointer].getTotalPoints()));
                        System.out.println("Roll again? (Y/n) ");
                        String answer = scanner.nextLine();
                        if (answer.equalsIgnoreCase("n")) {
                            players[playerTurnPointer].updateTotalPoints(points);
                            players[playerTurnPointer].incrementTurnCount();
                            System.out.printf("%s now have %d of %d points\n" +
                                    "=====================================================\n",
                                    players[playerTurnPointer].getName(), players[playerTurnPointer].getTotalPoints(), endGoal);
                            points = 0;
                            incrementPlayerTurnPointer();
                        }
                    }
                } else {
                    if (points + players[playerTurnPointer].getTotalPoints() > endGoal) {
                        players[playerTurnPointer].updateTotalPoints(points);
                        players[playerTurnPointer].incrementTurnCount();
                        printVictory();
                        finished = true;
                    } else {
                        int decider = (int) Math.round(Math.random());
                        if (decider == 1) {
                            players[playerTurnPointer].updateTotalPoints(points);
                            players[playerTurnPointer].incrementTurnCount();
                            System.out.printf("%s now have %d of %d points\n" +
                                    "=====================================================\n",
                                    players[playerTurnPointer].getName(), players[playerTurnPointer].getTotalPoints(), endGoal);
                            points = 0;
                            incrementPlayerTurnPointer();
                        }
                    }
                }
            }
        }
    }

    public void printVictory() {
        System.out.println("=====================================================");
        System.out.println(players[playerTurnPointer].getName() + " has won the game");
        printStats();
    }

    public void printStats() {
        System.out.println("=====================================================");
        for (Player player : players) {
            player.calculateAverageValue();
            player.calculateLostValue();
            System.out.printf("%s rolled %d times in %d turns with an average value of %.1f per turn and %d lost points\n", player.getName(), player.getThrowCount(), player.getTurnCount(), player.getAverageValue(), player.getLostValue());
        }
        System.out.println("=====================================================");
    }

    public void incrementPlayerTurnPointer() {
        if (playerTurnPointer < players.length - 1) {
            playerTurnPointer++;
        } else {
            playerTurnPointer = 0;
        }
    }

    public void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of Pig:");
        System.out.println("The game is played by up to n players.");
        System.out.println("The players take turns, throwing two dice until he/she/it throws 1, or until he/she/it decides to stop throwing.");
        System.out.println("The player accumulates points (the face value of the dice) on each throw, but if he/she/it throws 1, all points in this turn is lost.");
        System.out.println("If the player stops before throwing a 1, the points of this turn is added to the points of earlier turns.");
        System.out.println("If both dice are showing 1, the player's collected points is reset to zero.");
        System.out.println("If both dice show the same (but not 1-1), the player must throw again.");
        System.out.println("The player that reaches the decided amount of points after a turn, is the winner.");
        System.out.println("=====================================================");
    }

    public void setNumberOfPlayers() {
        while (numberOfPlayers == -1) {
            int tempValue = -1;
            System.out.print("Input number of players (between 0 and " + maxPlayers + "): ");
            if (scanner.hasNextInt()) {
                tempValue = scanner.nextInt();
                scanner.nextLine(); // throw away the \n not consumed by nextInt()
            } else {
                scanner.nextLine();
            }
            if (0 <= tempValue && tempValue <= maxPlayers) {
                numberOfPlayers = tempValue;
            } else {
                System.out.println("Not a valid entry try again.");
            }
        }
    }

    public void setNumberOfAIs() {
        while (numberOfAIs == -1) {
            int tempValue = -1;
            int maxAIs = maxPlayers - numberOfPlayers;
            System.out.print("Input number of AI opponents (between 0 and " + maxAIs + ") ");
            if (scanner.hasNextInt()) {
                tempValue = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }
            if (0 <= tempValue && tempValue <= maxAIs) {
                numberOfAIs = tempValue;
            } else {
                System.out.println("Not a valid entry try again.");
            }
        }
    }

    public void populatePlayers() {
        players = new Player[numberOfPlayers + numberOfAIs];
        for (int i = 0; i < numberOfPlayers + numberOfAIs; i++) {
            int tempValue = i + 1;
            if (i < numberOfPlayers) {
                System.out.print("Player " + tempValue + " type alias: ");
                String tempString = scanner.nextLine();
                players[i] = new Player(tempString);
            } else {
                players[i] = new Player("AI" + (tempValue - numberOfPlayers));
            }
        }
    }

    public void setEndGoal() {
        while (endGoal == 0) {
            int tempValue = 0;
            System.out.print("Input end goal (between " + lowerLimit + " and " + upperLimit + "): ");
            if (scanner.hasNextInt()) {
                tempValue = scanner.nextInt();
                scanner.nextLine(); // throw away the \n not consumed by nextInt()
            } else {
                scanner.nextLine();
            }
            if (lowerLimit <= tempValue && tempValue <= upperLimit) {
                endGoal = tempValue;
            } else {
                System.out.println("Not a valid entry try again.");
            }
        }
    }
}