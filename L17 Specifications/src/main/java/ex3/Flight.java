package ex3;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 * Model a flight with an airline between airports.
 */
public class Flight {
	    private String flightNumber;
	    private String destination;
	    private LocalDateTime departure;
	    private LocalDateTime arrival;
	    private final ArrayList<Passenger> passengers = new ArrayList<>();

	/**
	 * Create a flight.<br/>
	 * Pre: flightNumber is not empty, destination is not empty.
	 */
	public Flight(String flightNumber, String destination) {
		this.flightNumber = flightNumber;
		this.destination = destination;
	}

	/**
	 * Return the destination.
	 */
	public String getDestination() {
		return destination;
	}

	/**
	 * Return the flight number.
	 */
	public String getFlightNumber() {
		return flightNumber;
	}

	/**
	 * Return the date and time of departure.<br/>
	 */
	public LocalDateTime getDeparture() {
		return departure;
	}

	/**
	 * Set the date and time of departure.<br>
	 */
	public void setDeparture(LocalDateTime departure) {
		this.departure = departure;
	}

	/**
	 * Return the date and time of arrival.<br/>
	 */
	public LocalDateTime getArrival() {
		return arrival;
	}

	/**
	 * Set the date and time of arrival.<br/>
	 * Pre: Arrival date and time is after departure date and time.
	 */
	public void setArrival(LocalDateTime arrival) {
		this.arrival = arrival;
	}

	/**
	 * Return a copy of the passenger list.
	 */
	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	/**
	 * Create and return a passenger added to the passenger list.<br/>
	 * Pre: name is not empty, age >= 0.
	 */
	public Passenger addPassenger(String name, int age) {
		Passenger passenger = new Passenger(name, age);
		passengers.add(passenger);
		return passenger;
	}

	/**
	 * Remove a named passenger from the passenger list.<br/>
	 * Return true, if the passenger is removed from the passenger list.<br/>
	 * Pre: name is not empty.
	 */
	public boolean removePassenger(String name) {
		for (int i = 0; i < passengers.size(); i++) {
			if (passengers.get(i).getName().equals(name)) {
				passengers.remove(i);
				return true;
			}
		}
		return false;
	}

	/**
	 * Return the duration of the flight measured in hours.<br/>
	 */
	public double durationInHours() {
		return departure.until(arrival, ChronoUnit.HOURS);
	}

	/**
	 * Return true if the flight time overlaps
	 * midnight of the day of departure.<br/>
	 */
	public boolean midnightFlight() {
		return !departure.getDayOfWeek().equals(arrival.getDayOfWeek());
	}

	/**
	 * Return the average age of all the passengers.<br/>
	 * Pre: The passenger list is not empty.
	 */
	public double averagePassengerAge() {
		int age = 0;
		for (Passenger passenger : passengers) {
			age += passenger.getAge();
		}
		age /= passengers.size();
		return age;
	}

}
