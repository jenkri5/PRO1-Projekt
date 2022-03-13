package games;

import java.util.Random;

public class Die {
	// number of faces
	private final int faceCount;
	// value of upper face
	private int faceValue;
	// instance of the random class
	private final Random rand = new Random();

	/**
	 * Creates a die with the given face count and a random face value.
	 */
	public Die(int faceCount) {
		this.faceCount = faceCount;
		this.faceValue = rand.nextInt(faceCount)+1;
	}

	/**
	 * Creates a die with 6 faces and a random face value.
	 */
	public Die() {
		this.faceCount = 6;
		this.faceValue = rand.nextInt(faceCount)+1;
	}

	/**
	 * Getters
	 */
	public int getFaceCount() {
		return faceCount;
	}

	public int getFaceValue() {
		return faceValue;
	}

	/**
	 * Rolls the die, resulting in a new face value.
	 */
	public void roll() {
		this.faceValue = rand.nextInt(faceCount)+1;
	}
}