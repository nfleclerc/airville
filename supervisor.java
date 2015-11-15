public class Supervisor {

	public static final int SUPERVISOR_BONUS = 2;
	
	public void speedUp(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed * SUPERVISOR_BONUS);
	}

	public void slowDown(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed / SUPERVISOR_BONUS);
	}

}
