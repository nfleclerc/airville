public abstract class Counter {
	
	private Supervisor supervisor;
	private int processSpeed;
	private List<Passenger> passengersInLine;
	
	private abstract processPassengers();

	private List<Passenger> getPassengersInLine(){
		return this.passengersInLine;
	}
	
	public void setSupervisor(Supervisor supervisor){
		this.supervisor = supervisor;
	}

	public int getProcessSpeed(){
		return this.processSpeed;
	}

	public void setProcessSpeed(int processSpeed){
		this.processSpeed = processSpeed;
	}
}
