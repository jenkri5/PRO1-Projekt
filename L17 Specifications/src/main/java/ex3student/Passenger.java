package ex3student;

/**
 * Model a passenger for a flight.
 */
public class Passenger {
	private String name;
	private int age;

	/**
	 * Create a passenger.<br/>
	 * Pre: name is not empty, age >= 0.
	 */
	public Passenger(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Return the name.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name.<br/>
	 * Pre: name is not empty.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the age.
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Set the age.<br/>
	 * Pre: age >= 0;
	 */
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}

}
