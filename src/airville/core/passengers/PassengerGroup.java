package airville.core.passengers;

import airville.core.gamepieces.counters.Counter;

import java.util.List;

/**
 * A group of Passengers.
 */
public class PassengerGroup {

	private List<Passenger> passengers;

	/**
	 * Instantiates a new Passenger Group.
	 * @param passengers Takes a List of Passengers to make this group from.
	 */
	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
	}

	/**
	 * Returns true if every Passenger in this group is of type Regular, and
	 * false otherwise.
	 * @return Whether or not this group only consists of Regular Passengers.
	 */
	public boolean isOfRegularPassengers(){
		for (Passenger passenger : passengers){
			if (passenger.getPassengerType() != PassengerType.REGULAR){
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns the size of this group.
	 * @return The size of this group.
	 */
	public int size(){
		return passengers.size();
	}

	/**
	 * Returns true if this group only consists of one Passenger.
	 * @return Whether or not this group is only one Passenger or not.
	 */
	public boolean isOnePassenger(){
		return passengers.size() == 1;
	}

	/**
	 * Queues this group at a given Counter.
	 * @param counter The Counter at which this group is to be queued at.
	 */
	public void queueAt(Counter counter){
		counter.getLine().add(this);
	}

	/**
	 * Process the whole group at a given Counter.
	 * @param counter The Counter at which this group is to be processed at.
	 */
	public void processAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.processAt(counter));
	}

	/**
	 * Returns the list of Passengers in this group.
	 * @return The List of Passengers in this group.
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

}


