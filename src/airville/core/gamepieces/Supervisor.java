package airville.core.gamepieces;

import airville.core.gamepieces.counters.Counter;
import java.util.Optional;

/**
 * A Supervisor that can help speed up how fast a Counter can Process Passengers. A Supervisor
 * is also required for a Counter to process a Rerouted Passenger.
 */
public class Supervisor implements GamePiece {

	private static final int SUPERVISOR_SPEEDUP_RATE = 2;
	private double busyTime;
	private boolean busy;
	private Optional<Counter> currentCounter;

	/**
	 * Applies the Supervisor speed bonus to the specified Counter.
 	 * @param counter The Counter at which the speed buff is to be applied.
	 */
	public void speedUp(Counter counter){
		busy = true;
		counter.setBusyTime(counter.getBusyTime() / SUPERVISOR_SPEEDUP_RATE);
	}

	/**
	 * Removes the Supervisor speed bonus from a Counter. Called when a Supervisor is leaving
	 * a counter.
 	 * @param counter The Counter which the Supervisor is leaving.
	 */
	public void slowDown(Counter counter){
		counter.setBusyTime(counter.getBusyTime() * SUPERVISOR_SPEEDUP_RATE);
	}

	/**
	 * Returns the Counter at which this Supervisor is currently stationed at.
	 * @return The Counter at which this Supervisor is currently Stationed at.
	 */
	public Counter getCurrentCounter(){
		return currentCounter.get();
	}

	/**
	 * Sets the Counter at which this Supervisor is to be stationed at.
	 * @param counter The Counter that this Supervisor is currently at.
	 */
	public void setCurrentCounter(Optional<Counter> counter) {
		this.currentCounter = counter;
	}

	@Override
	public boolean isBusy() {
		return busy;
	}

	@Override
	public double getBusyTime(){
		return busyTime;
	}

	@Override
	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

	@Override
	public GamePieceType getGamePieceType() {
		return GamePieceType.SUPERVISOR;
	}

}
