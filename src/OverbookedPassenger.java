public class OverbookedPassenger extends AbstractPassenger {

	public static final int OVERBOOKED_SPEED = 2;

	OverbookedPassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		//processes this passenger at a slower speed than normal
		counter.setProcessSpeed(counter.getProcessSpeed() / OVERBOOKED_SPEED);
		Player.getInstance().addPoints(OVERBOOKED_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * OVERBOOKED_SPEED);
	}

}
