package yahtzee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

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
		for (int i = 0; i < nDice; i++)
			m_Dice[i] = new Die();
	}

	public void roll() {
		Arrays.stream(m_Dice).filter(die -> !die.isLocked()).forEach(Die::roll);
		m_RollCount++;
	}

	public void sort() {
		m_Dice = Arrays.stream(m_Dice)
				.sorted(Comparator.comparing(Die::isLocked).reversed().thenComparingInt(Die::getFaceValue))
				.toArray(Die[]::new);
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
		for (Die die : m_Dice)
			System.out.print(die.getFaceValue() + " ");
		System.out.println();
	}

	private class Die {

		private static final Random rand = new Random();
		private final int m_FaceCount;
		private int m_FaceValue;
		private boolean m_IsLocked = false;

		public Die() {
			m_FaceCount = 6;
		}

		public int getFaceValue() {
			return m_FaceValue;
		}

		public void setLocked() {
			m_IsLocked = !m_IsLocked;
		}

		public boolean isLocked() {
			return m_IsLocked;
		}

		public void roll() {
			this.m_FaceValue = rand.nextInt(0, m_FaceCount) + 1;
		}

	}

}
