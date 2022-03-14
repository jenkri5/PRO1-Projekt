package yahtzee;

import java.util.Arrays;
import java.util.Comparator;

public class DiceThrower {

    private Die[] m_Dices;
    private int m_RollCount;
    private final int m_nDices;
    
    public DiceThrower(int nDices) {
    	m_Dices = new Die[nDices];
    	m_RollCount = 0;
    	m_nDices = nDices;
    	generateDices(nDices);
    }
    
	public void generateDices(int nDices) {
    	for(int i = 0; i < nDices; i++)
    		m_Dices[i] = new Die();
    }

    public void roll() {
        for(Die die : m_Dices)
            if(!die.isLocked())
                die.roll();
        m_RollCount++;
    }
    
    public void roll2() {
    	Arrays.stream(m_Dices).filter(die -> !die.isLocked()).forEach(Die::roll);
    	m_RollCount++;   
    	
    }

    public void roll3() {
    	Arrays.stream(m_Dices).filter(die -> !die.isLocked()).forEach(Die::roll);
    	m_Dices = Arrays.stream(m_Dices).sorted(Comparator.comparing(Die::isLocked).reversed().thenComparingInt(Die::getFaceValue)).toArray(Die[]::new);
    	m_RollCount++;
    }
    
    public Die[] getDices() {
    	return m_Dices;
    }
    
    public Die getDie(int i) {
    	return m_Dices[i];
    }
    
    public int getNDices() {
    	return m_nDices;
    }

    public int getRollCount() {
        return m_RollCount;
    }

    public void resetRollCount() {
        m_RollCount = 0;
    }

    public void lock(int i) {
        m_Dices[i].setLocked();
    }

    public void print() {
        for(Die die : m_Dices)
            System.out.print(die.getFaceValue()+" ");
        System.out.println();
    }

}
