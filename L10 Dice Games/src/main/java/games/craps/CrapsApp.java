package games.craps;

public class CrapsApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Craps.");

        CrapsGame game = new CrapsGame();
        game.printRules();
        System.out.println();

        game.play();
        // game.runSimulation(10000);

        System.out.println("Thank you for playing craps.");
    }
}
