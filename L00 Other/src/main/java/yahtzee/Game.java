package yahtzee;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private static final ArrayList<Player> PLAYERS = new ArrayList<>();
    private static final DiceThrower DICE_THROWER = new DiceThrower();
    private static final Scanner SCANNER = new Scanner(System.in);
    private static Board m_board;

    public static void main(String[] args) {

        System.out.print("How many players: ");
        int n = SCANNER.nextInt();

        for(int i = 0; i < n; i++) {
            int playerNumber = i+1;
            String playerName = "Player "+playerNumber;
            PLAYERS.add(new Player(playerName));
        }

        m_board = new Board(PLAYERS.size());

        m_board.print();

    }
}
