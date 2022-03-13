package games.simple;

public class SimpleApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the game of Simple.");

        SimpleGame game = new SimpleGame();
        game.printRules();
        System.out.println();

        game.play();

        System.out.println("Thank you for playing Simple.");
    }

}
