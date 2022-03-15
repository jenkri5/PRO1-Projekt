package yahtzee;

public class Game {

	private final int[] PLAYERS;
	private final int[][] BOARD;
	private final DiceThrower DICE_THROWER;
	private boolean m_GAME_OVER;
	private int m_PlayerTurn;

	public Game(int nPlayers, int nDice) {
		PLAYERS = new int[nPlayers];
		BOARD = new int[LowerSection.values().length + UpperSection.values().length][nPlayers];
		DICE_THROWER = new DiceThrower(nDice);
		m_PlayerTurn = 0;
	}

	public void initialize() {
		for (int i = 0; i < PLAYERS.length; i++)
			PLAYERS[i] = i;
	}

	public void run() {
		while (!m_GAME_OVER) {
			// GAME LOGIC
			DICE_THROWER.roll();
			DICE_THROWER.print();
			DICE_THROWER.roll();
			DICE_THROWER.print();
			DICE_THROWER.roll();
			DICE_THROWER.print();
			DICE_THROWER.roll();
			DICE_THROWER.print();
			DICE_THROWER.roll();
			DICE_THROWER.print();
			m_GAME_OVER = true;
		}
	}

	public void printBoard() {
		for (int[] scores : BOARD) {
			for (int score : scores)
				System.out.print(score);
			System.out.println();
		}
	}

	public void incrementPlayerTurn() {
		if (m_PlayerTurn >= PLAYERS.length - 1)
			m_PlayerTurn = 0;
		else
			m_PlayerTurn++;
	}

	public void setScore(int section, int player, int score) {
		BOARD[section][player] = score;
	}

}
