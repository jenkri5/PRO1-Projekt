package yahtzee;

import java.util.ArrayList;
import java.util.Arrays;

public class DiceThrower {

    private final Die
            m_die1 = new Die(),
            m_die2 = new Die(),
            m_die3 = new Die(),
            m_die4 = new Die(),
            m_die5 = new Die();

    private final ArrayList<Die> m_dices = new ArrayList<>(Arrays.asList(m_die1,m_die2,m_die3,m_die4,m_die5));

    private int m_rollCount = 0;

    public void roll() {
        for(Die die : m_dices) {
            if(!die.isLocked())
                die.roll();
        }
        m_rollCount++;
    }

    public int getRollCount() {
        return m_rollCount;
    }

    public void resetRollCount() {
        m_rollCount = 0;
    }

    public void lock(int i) {
        m_dices.get(i).setLocked();
    }

    public void print() {
        for(Die die : m_dices)
            System.out.print(die.getFaceValue()+" ");
        System.out.println();
    }


}
