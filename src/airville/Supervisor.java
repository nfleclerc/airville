package airville;

public class Supervisor implements GamePiece{

	public static final int SUPERVISOR_BONUS = 2;

	private Counter currentCounter;

	//apply the speed buff supervisor grants to the counter
	public void speedUp(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() * SUPERVISOR_BONUS);
	}

	//remove the speed buff supervisor grants to the counter
	public void slowDown(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() / SUPERVISOR_BONUS);
	}

	public Counter getCurrentCounter(){
		return currentCounter;
	}

	public void setCurrentCounter(Counter counter) {
		this.currentCounter = counter;
	}

}
