public class Supervisor {

	public static final int SUPERVISOR_BONUS = 2;

	private Counter currentCounter;
	
	public void speedUp(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() * SUPERVISOR_BONUS);
	}

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
