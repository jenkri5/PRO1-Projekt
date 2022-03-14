package yahtzee;

public class Game {

	private int[] PLAYERS;
	private final DiceThrower DICE_THROWER = new DiceThrower(5);
	private Board m_Board;
	private static int m_PlayerTurn;
	private boolean GAMEOVER;
	
	public Game(int nPlayers) {
		PLAYERS = new int[nPlayers];
		m_PlayerTurn = 0;
	}

	public static boolean isPlayerTurn(int iPlayer, int nPlayers) {
		return m_PlayerTurn % nPlayers == iPlayer;
	}

	public static void incrementPlayerTurn(int nPlayers) {
		if (m_PlayerTurn == nPlayers-1)
			m_PlayerTurn = 0;
		else
			m_PlayerTurn++;
	}

	public void initialize() {
		for(int i = 0; i < PLAYERS.length; i++)
			PLAYERS[i] = i;
		m_Board = new Board(PLAYERS.length);
	}

	public void run() {
		while(!GAMEOVER) {			
			GAMEOVER = true;
		}
	}

}
