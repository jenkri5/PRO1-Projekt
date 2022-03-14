package yahtzee;

public class Board {

    private final int[][] m_board;

    public Board(int nPlayers) {
        m_board = new int[LowerSection.values().length+UpperSection.values().length][nPlayers];
    }

    public void print() {
        for(int i = 0; i < m_board.length; i++) {
            for(int j = 0; j < m_board[i].length; j++) {
                System.out.print(m_board[i][j]);
            }
            System.out.println();
        }
    }

    public void setScore(int section, int player, int score) {
        m_board[player][section] = score;
    }

}
