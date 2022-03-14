package yahtzee;

public class Board {

    private final int[][] m_Board;

    public Board(int nPlayers) {
        m_Board = new int[LowerSection.values().length+UpperSection.values().length][nPlayers];
    }

    public void print() {
        for (int[] scores : m_Board) {
            for (int score : scores) {
                System.out.print(score);
            }
            System.out.println();
        }
    }

    public void setScore(int section, int player, int score) {
        m_Board[section][player] = score;
    }

}
