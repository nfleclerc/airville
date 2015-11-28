package airville.gamepieces.counters;

import airville.gamepieces.Supervisor;
import airville.passengers.PassengerGroup;

import java.util.*;

public abstract class Counter {

	private Optional<Supervisor> supervisor;
	private double busyTime;
	private Queue<PassengerGroup> line;
	private static final int STARTING_PROCESS_BUSY_TIME = 1;

	public Counter(){
		this.supervisor = Optional.empty();
		this.busyTime = STARTING_PROCESS_BUSY_TIME;
		this.line = new PriorityQueue<>();
	}

	public abstract void processPassengers();

	public Queue<PassengerGroup> getLine(){
		return this.line;
	}
	
	public void setSupervisor(Supervisor supervisor){
		this.supervisor = Optional.of(supervisor);
	}

	public double getBusyTime(){
		return this.busyTime;
	}

	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

	public boolean hasSupervisor() {
		return supervisor.isPresent();
	}

}
