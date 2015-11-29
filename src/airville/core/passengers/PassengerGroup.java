package airville.core.passengers;

import airville.core.gamepieces.counters.Counter;

import java.util.List;

/**
 *
 */
public class PassengerGroup {

	private List<Passenger> passengers;

	/**
	 *
	 * @param passengers
	 */
	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
	}

	/**
	 *
	 * @return
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
	 *
	 * @return
	 */
	public int size(){
		return passengers.size();
	}

	/**
	 *
	 * @return
	 */
	public boolean isOnePassenger(){
		return passengers.size() == 1;
	}

	/**
	 *
	 * @param counter
	 */
	public void queueAt(Counter counter){
		counter.getLine().add(this);
	}

	/**
	 *
	 * @param counter
	 */
	public void processAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.processAt(counter));
	}

	/**
	 *
	 * @return
	 */
	public List<Passenger> getPassengers() {
		return passengers;
	}

}


