package airville.gamepieces.counters;

import airville.gamepieces.GamePiece;
import airville.gamepieces.Supervisor;
import airville.passengers.PassengerGroup;

import java.util.*;

public abstract class Counter implements GamePiece{

	private Optional<Supervisor> supervisor;
	private double busyTime;
	private Queue<PassengerGroup> line;
	private static final int STARTING_BUSY_TIME = 0;
	protected boolean busy;

	public Counter(){
		this.supervisor = Optional.empty();
		this.busyTime = STARTING_BUSY_TIME;
		this.line = new PriorityQueue<>();
		this.busy = false;
	}

	public abstract void processPassengers();

	public Queue<PassengerGroup> getLine() {
		return line;
	}
	
	public void setSupervisor(Optional<Supervisor> supervisor){
		this.supervisor = supervisor;
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

	@Override
	public boolean isBusy(){
		return this.busy;
	}

}
