package yahtzee;

public class Player {

    private final String m_name;
    private boolean m_myTurn = false;

    public Player(String name) {
        m_name = name;
    }

    public String getName() {
        return m_name;
    }

    public void setTurn() {
        m_myTurn = !m_myTurn;
    }
}
