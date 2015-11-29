package airville.gamepieces;

import airville.gamepieces.counters.Counter;

import java.util.Optional;

public class Supervisor implements GamePiece {

	public static final int SUPERVISOR_SPEEDUP_RATE = 2;
	public double busyTime;
	public boolean busy;
	private Optional<Counter> currentCounter;

	//apply the speed buff supervisor grants to the counter
	public void speedUp(Counter counter){
		busy = true;
		counter.setBusyTime(counter.getBusyTime() / SUPERVISOR_SPEEDUP_RATE);
	}

	//remove the speed buff supervisor grants to the counter
	public void slowDown(Counter counter){
		counter.setBusyTime(counter.getBusyTime() * SUPERVISOR_SPEEDUP_RATE);
	}

	public Counter getCurrentCounter(){
		return currentCounter.get();
	}

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

	public void setBusyTime(double busyTime){
		this.busyTime = busyTime;
	}

}
