package airville.core.passengers;

import airville.core.gamepieces.counters.Counter;

import java.util.List;

public class PassengerGroup {

	private List<Passenger> passengers;

	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
	}

	public boolean isOfRegularPassengers(){
		for (Passenger passenger : passengers){
			if (passenger.getPassengerType() != PassengerType.REGULAR){
				return false;
			}
		}
		return true;
	}

	public int size(){
		return passengers.size();
	}

	public boolean isOnePassenger(){
		return passengers.size() == 1;
	}

	//queues the group at a counter
	public void queueAt(Counter counter){
		counter.getLine().add(this);
	}

	public void processAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.processAt(counter));
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

}


