package yahtzee;

import java.util.Scanner;

public class Main {

	private static final Scanner SCANNER = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Input number of players: ");
		int n = SCANNER.nextInt();
		Game game = new Game(n, 5);

		game.initialize();
		game.run();

		SCANNER.close();
	}

}