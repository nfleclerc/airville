package airville.core.gamepieces.counters;

import airville.core.gamepieces.GamePiece;
import airville.core.gamepieces.Supervisor;
import airville.core.passengers.PassengerGroup;

import java.util.*;

/**
 *
 */
public abstract class Counter implements GamePiece{

	private Optional<Supervisor> supervisor;
	private double busyTime;
	private Queue<PassengerGroup> line;
	private static final int STARTING_BUSY_TIME = 0;
	protected boolean busy;

	/**
	 *
	 */
	public Counter(){
		this.supervisor = Optional.empty();
		this.busyTime = STARTING_BUSY_TIME;
		this.line = new PriorityQueue<>();
		this.busy = false;
	}

	/**
	 *
	 */
	public abstract void processPassengers();

	/**
	 *
	 * @return
	 */
	public Queue<PassengerGroup> getLine() {
		return line;
	}

	/**
	 *
	 * @param supervisor
	 */
	public void setSupervisor(Optional<Supervisor> supervisor){
		this.supervisor = supervisor;
	}

	/**
	 *
	 * @return
	 */
 	public double getBusyTime(){
		return this.busyTime;
	}

	/**
	 *
	 * @param busyTime
	 */
	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

	/**
	 *
	 * @return
	 */
	public boolean hasSupervisor() {
		return supervisor.isPresent();
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean isBusy(){
		return this.busy;
	}

}
