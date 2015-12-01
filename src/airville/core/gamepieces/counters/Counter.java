package airville.core.gamepieces.counters;

import airville.core.gamepieces.GamePiece;
import airville.core.gamepieces.Supervisor;
import airville.core.passengers.PassengerGroup;

import java.util.*;

/**
 * An Abstract Counter Class. A Counter processes Passengers that are queued in its line.
 */
public abstract class Counter implements GamePiece{

	private Optional<Supervisor> supervisor;
	private double busyTime;
	private Queue<PassengerGroup> line;
	private static final int STARTING_BUSY_TIME = 0;
	protected boolean busy;

	/**
	 * Creates a new Counter and sets its fields.
	 */
	public Counter(){
		this.supervisor = Optional.empty();
		this.busyTime = STARTING_BUSY_TIME;
		this.line = new PriorityQueue<>();
		this.busy = false;
	}

	/**
	 * Process Passengers. This is implemented by RegularCounter and AutomaticCounter.
	 */
	public abstract void processPassengers();

	/**
	 * Getter to return the line of Passengers. Passengers line up by group. If the Passenger is
	 * alone it is treated as a group of 1 Passenger.
	 * @return The line for this Counter.
	 */
	public Queue<PassengerGroup> getLine() {
		return line;
	}

	/**
	 * Sets the Supervisor of this Counter.
	 * @param supervisor An Optional value of Supervisor.
	 */
	public void setSupervisor(Optional<Supervisor> supervisor){
		this.supervisor = supervisor;
	}



	/**
	 * Returns true if this Counter has a Supervisor, false otherwise.
	 * @return Whether or not this Counter has a SUpervisor.
	 */
	public boolean hasSupervisor() {
		return supervisor.isPresent();
	}

	@Override
	public boolean isBusy(){
		return this.busy;
	}

	@Override
	public double getBusyTime(){
		return this.busyTime;
	}

	@Override
	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

}
