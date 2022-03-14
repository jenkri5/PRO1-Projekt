package yahtzee;

public class Board {

    private final int[][] m_Board;

    public Board(int nPlayers) {
        m_Board = new int[LowerSection.values().length+UpperSection.values().length][nPlayers];
    }

    public void print() {
        for(int i = 0; i < m_Board.length; i++) {
            for(int j = 0; j < m_Board[i].length; j++) {
                System.out.print(m_Board[i][j]);
            }
            System.out.println();
        }
    }

    public void setScore(int section, int player, int score) {
        m_Board[section][player] = score;
    }

}
