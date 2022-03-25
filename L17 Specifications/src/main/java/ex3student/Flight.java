package ex3student;

import java.time.LocalDateTime;

/**
 * Model a flight with an airline between airports.
 */
public class Flight {
	//    private String flightNumber;
	//    private String destination;
	//    private LocalDateTime departure;
	//    private LocalDateTime arrival;
	//    private final ArrayList<Passenger> passengers = new ArrayList<>();

	/**
	 * Create a flight.<br/>
	 * Pre: flightNumber is not empty, destination is not empty.
	 */
	public Flight(String flightNumber, String destination) {
		// TODO
	}

	/**
	 * Return the destination.
	 */
	// TODO

	/**
	 * Return the flight number.
	 */
	// TODO

	/**
	 * Return the date and time of departure.<br/>
	 */
	// TODO

	/**
	 * Set the date and time of departure.<br>
	 */
	public void setDeparture(LocalDateTime departure) {
		// TODO
	}

	/**
	 * Return the date and time of arrival.<br/>
	 */
	// TODO

	/**
	 * Set the date and time of arrival.<br/>
	 * Pre: Arrival date and time is after departure date and time.
	 */
	public void setArrival(LocalDateTime arrival) {
		// TODO
	}
	/**
	 * Return a copy of the passenger list.
	 */
	// TODO

	/**
	 * Create and return a passenger added to the passenger list.<br/>
	 * Pre: name is not empty, age >= 0.
	 */
	public Passenger addPassenger(String name, int age) {
		// TODO
		return null;
	}

	/**
	 * Remove a named passenger from the passenger list.<br/>
	 * Return true, if the passenger is removed from the passenger list.<br/>
	 * Pre: name is not empty.
	 */
	public boolean removePassenger(String name) {
		// TODO
		return false;
	}

	/**
	 * Return the duration of the flight measured in hours.<br/>
	 */
	public double durationInHours() {
		// TODO
		return 0.0;
	}

	/**
	 * Return true if the flight time overlaps
	 * midnight of the day of departure.<br/>
	 */
	public boolean midnightFlight() {
		// TODO
		return false;
	}

	/**
	 * Return the average age of all the passengers.<br/>
	 * Pre: The passenger list is not empty.
	 */
	public double averagePassengerAge() {
		// TODO
		return 0.0;
	}

}
