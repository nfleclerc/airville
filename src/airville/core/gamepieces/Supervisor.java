package airville.core.gamepieces;

import airville.core.gamepieces.counters.Counter;

import java.util.Optional;

/**
 *
 */
public class Supervisor implements GamePiece {

	private static final int SUPERVISOR_SPEEDUP_RATE = 2;
	private double busyTime;
	private boolean busy;
	private Optional<Counter> currentCounter;

	/**
	 *
 	 * @param counter
	 */
	public void speedUp(Counter counter){
		busy = true;
		counter.setBusyTime(counter.getBusyTime() / SUPERVISOR_SPEEDUP_RATE);
	}

	/**
	 *
 	 * @param counter
	 */
	public void slowDown(Counter counter){
		counter.setBusyTime(counter.getBusyTime() * SUPERVISOR_SPEEDUP_RATE);
	}

	/**
	 *
	 * @return
	 */
	public Counter getCurrentCounter(){
		return currentCounter.get();
	}

	/**
	 *
	 * @param counter
	 */
	public void setCurrentCounter(Optional<Counter> counter) {
		this.currentCounter = counter;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public boolean isBusy() {
		return busy;
	}

	/**
	 *
	 * @return
	 */
	@Override
	public double getBusyTime(){
		return busyTime;
	}

	/**
	 *
	 * @param busyTime
	 */
	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

}
