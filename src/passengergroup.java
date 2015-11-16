import java.util.List;

public class PassengerGroup {

	private List<Passenger> passengers;

	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
		passengers.stream().forEach(passenger -> passenger.setInGroup(true));
		passengers.stream().forEach(passenger -> passenger.setGroup(this));
	}

	public void queueAt(Counter counter){
		passengers.stream().forEach(passenger -> passenger.queueAt(counter));
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

}


