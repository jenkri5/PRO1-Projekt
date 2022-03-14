package yahtzee;

public class Game {

	private final int[] PLAYERS;
	private final int[][] BOARD;
	private final DiceThrower DICE_THROWER = new DiceThrower(5);
	private int m_PlayerTurn;
	private boolean GAME_OVER;
	
	public Game(int nPlayers) {
		PLAYERS = new int[nPlayers];
		BOARD = new int[LowerSection.values().length+UpperSection.values().length][nPlayers];
		m_PlayerTurn = 0;
	}

	public void initialize() {
		for(int i = 0; i < PLAYERS.length; i++)
			PLAYERS[i] = i;
	}

	public void run() {
		while(!GAME_OVER) {
			// GAME LOGIC
			
			GAME_OVER = true;
		}
	}

	public void printBoard() {
		for (int[] scores : BOARD) {
			for (int score : scores) {
				System.out.print(score);
			}
			System.out.println();
		}
	}

	public void incrementPlayerTurn() {
		if (m_PlayerTurn >= PLAYERS.length-1)
			m_PlayerTurn = 0;
		else
			m_PlayerTurn++;
	}
	
	public void setScore(int section, int player, int score) {
		BOARD[section][player] = score;
	}

}
