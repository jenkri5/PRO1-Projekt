package games;

public class DiceThrower {

	// 2 dice with face count of 6 each
	private final Die die1 = new Die(), die2 = new Die();

	// Fields:
	// 1. The roll count.
	// 2. The total of all face values rolled.
	// 3. The count of face value 6.
	// 4. The count of same face value on both dice.
	// 5. The maximum sum of the face values in one roll.
	// Remember to update fields, when the dice are rolled.
	private int rollCount = 0, totalValue = 0, sixCount = 0, sameFaceCount, biggestRoll = 0;

	/**
	 * Creates a DiceThrower object.
	 */
	public DiceThrower() { }

	/**
	 * Getters
	 */
	public int getRollCount() {
		return rollCount;
	}

	public int getTotalValue() {
		return totalValue;
	}

	public int getSixCount() {
		return sixCount;
	}

	public int getSameFaceCount() {
		return sameFaceCount;
	}

	public int getBiggestRoll() {
		return biggestRoll;
	}

	/**
	 * Rolls the 2 dice.
	 */
	public void roll() {
		die1.roll();
		die2.roll();
		rollCount++;
		totalValue += sum();
		if(die1.getFaceValue()==6) { sixCount++; }
		if(die2.getFaceValue()==6) { sixCount++; }
		if(die1.getFaceValue()==die2.getFaceValue()) { sameFaceCount++; }
		if(sum()>biggestRoll) { biggestRoll = sum(); }
 	}

	/**
	 * Returns the sum of the face values in a roll.
	 */
	public int sum() {
		return die1.getFaceValue()+die2.getFaceValue();
	}

	public int getDie1FaceValue() { return die1.getFaceValue(); }

	public int getDie2FaceValue() { return die2.getFaceValue(); }

	/**
	 * Returns a textual description of the roll of the 2 dice.
	 * Example: Returns "(4,5)" for a roll of 4 and 5.
	 */
	public String rollDescription() {
		return String.format("(%d,%d)",die1.getFaceValue(),die2.getFaceValue());
	}
}
