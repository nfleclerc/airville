package airville;

import java.util.List;

public class PassengerGroup {

	private List<Passenger> passengers;

	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
		passengers.stream().forEach(passenger -> passenger.setGroup(this));
		passengers.stream().forEach(passenger -> passenger.setInGroup(true));
	}

	//queues the whole group at the same counter
	public void queueAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.queueAt(counter));
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

}


