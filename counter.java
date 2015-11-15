public abstract class Counter {
	
	private Supervisor supervisor;
	private int processSpeed;
	private Queue<Passenger> passengersInLine;
	
	private abstract processPassengers();

	private Queue<Passenger> getPassengersInLine(){
		return this.passengersInLine;
	}

}
