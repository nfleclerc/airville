package airville.passengers;

import airville.gamepieces.counters.Counter;
import airville.passengers.Passenger;

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

	//queues the whole group at the same counter
	public void queueAt(Counter counter){
		counter.getLine().add(this);
	}

	//processes the
	public void processAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.processAt(counter));
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

}


