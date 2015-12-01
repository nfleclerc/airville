package airville.core.passengers;

/**
 * An Enum describing each type of Passenger. Passengers can either be Regular, Rerouted,
 * have Extra Baggage, or be Overbooked.
 */
public enum PassengerType {

	REGULAR(1, 1),
	REROUTED(1, 10),
	EXTRABAGGAGE(2, 5),
	OVERBOOKED(1.5, 5);

	private double busyTime;
	private int points;

	PassengerType(double busyTime, int points){
		this.busyTime = busyTime;
		this.points = points;
	}

	/**
	 * Returns how long this type of Passenger is busy for when it is being processed.
	 * @return The amount of time is takes to process this Passenger.
	 */
	public double getBusyTime(){
		return this.busyTime;
	}

	/**
	 * Return the amount of points this type of Passenger is worth when successfully processed.
	 * @return The amount of points this type of Passenger is worth.
	 */
	public int getPoints(){
		return this.points;
	}

}
