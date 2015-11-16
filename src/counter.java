import java.util.List;

public abstract class Counter {
	
	private Supervisor supervisor;
	private int processSpeed;
	private List<Passenger> passengersInLine;
	
	public abstract void processPassengers();

	public List<Passenger> getPassengersInLine(){
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

	public boolean hasSupervisor() {
		return false;
	}
}
