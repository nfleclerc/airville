package airville;

import java.util.LinkedList;
import java.util.List;

public abstract class Counter {
	
	private Supervisor supervisor;
	private boolean hasSupervisor;
	private int processSpeed;
	private List<Passenger> passengersInLine;
	
	public abstract void processPassengers();

	public Counter(){
		this.supervisor = null;
		this.hasSupervisor = false;
		this.processSpeed = 1;
		this.passengersInLine = new LinkedList<>();
	}

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
		return hasSupervisor;
	}

	public void setHasSupervisor(boolean hasSupervisor) {
		this.hasSupervisor = hasSupervisor;
	}
}