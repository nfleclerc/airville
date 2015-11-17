public class OverbookedPassenger extends AbstractPassenger {

	public static final int OVERBOOKED_SPEED = 2;

	OverbookedPassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() / OVERBOOKED_SPEED);
		Player.getInstance().addPoints(OVERBOOKED_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * OVERBOOKED_SPEED);
	}

}
