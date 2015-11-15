public class PassengerGroup {

	private List<Passenger> passengers;

	public PassengerGroup(List<Passenger> passengers){
		this.passengers = passengers;
		passengers.stream().foreach(passenger -> passenger.setInGroup(true));
		passengers.stream().foreach(passenger -> passenger.setGroup(this));
	}

	public void queueAt(Counter counter){
		passengers.stream().foreach(passenger -> passenger.queueAt(counter));
	}

}


