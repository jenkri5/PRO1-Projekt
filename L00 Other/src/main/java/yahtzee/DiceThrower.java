package yahtzee;

import java.util.Arrays;
import java.util.Comparator;

public class DiceThrower {

    private Die[] m_Dice;
    private int m_RollCount;
    private final int m_nDice;
    
    public DiceThrower(int nDice) {
    	m_Dice = new Die[nDice];
    	m_RollCount = 0;
    	m_nDice = nDice;
    	generateDice(nDice);
    }
    
	public void generateDice(int nDice) {
    	for(int i = 0; i < nDice; i++)
    		m_Dice[i] = new Die();
    }

    public void roll() {
        for(Die die : m_Dice)
            if(!die.isLocked())
                die.roll();
        m_RollCount++;
    }
    
    public void roll2() {
    	Arrays.stream(m_Dice).filter(die -> !die.isLocked()).forEach(Die::roll);
    	m_RollCount++;   
    	
    }

    public void roll3() {
    	Arrays.stream(m_Dice).filter(die -> !die.isLocked()).forEach(Die::roll);
    	m_Dice = Arrays.stream(m_Dice).sorted(Comparator.comparing(Die::isLocked).reversed().thenComparingInt(Die::getFaceValue)).toArray(Die[]::new);
    	m_RollCount++;
    }
    
    public Die[] getDice() {
    	return m_Dice;
    }
    
    public Die getDie(int i) {
    	return m_Dice[i];
    }
    
    public int getNDice() {
    	return m_nDice;
    }

    public int getRollCount() {
        return m_RollCount;
    }

    public void resetRollCount() {
        m_RollCount = 0;
    }

    public void lock(int i) {
        m_Dice[i].setLocked();
    }

    public void print() {
        for(Die die : m_Dice)
            System.out.print(die.getFaceValue()+" ");
        System.out.println();
    }

}
