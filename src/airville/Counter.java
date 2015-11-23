package airville;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public abstract class Counter implements GamePiece{

	private Optional<Supervisor> supervisor;
	private double processSpeed;
	private List<Passenger> passengersInLine;
	private static final int STARTING_PROCESS_SPEED = 1;

	public Counter(){
		this.supervisor = Optional.empty();
		this.processSpeed = STARTING_PROCESS_SPEED;
		this.passengersInLine = new LinkedList<>();
	}

	public abstract void processPassengers();

	public List<Passenger> getPassengersInLine(){
		return this.passengersInLine;
	}
	
	public void setSupervisor(Supervisor supervisor){
		this.supervisor = Optional.of(supervisor);
	}

	public double getProcessSpeed(){
		return this.processSpeed;
	}

	public void setProcessSpeed(double processSpeed){
		this.processSpeed = processSpeed;
	}

	public boolean hasSupervisor() {
		return supervisor.isPresent();
	}

	public void clearLine(){
		passengersInLine = new LinkedList<>();
	}
}
