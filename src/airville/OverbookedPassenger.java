package airville;

public class OverbookedPassenger extends AbstractPassenger {

	private static final int OVERBOOKED_SPEED = 2;
	private static final int OVERBOOKED_POINTS = 10;

	OverbookedPassenger(boolean frequentFlyer){
		super(frequentFlyer);
		setPassengerType(PassengerType.OVERBOOKED);
	}

	@Override
	public void processAt(Counter counter){
		//processes this passenger at a slower speed than normal
		counter.setProcessSpeed(counter.getProcessSpeed() / OVERBOOKED_SPEED);
		Player.getInstance().addPoints(OVERBOOKED_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * OVERBOOKED_SPEED);
	}

	public static int getPointValue() {
		return OVERBOOKED_POINTS;
	}
}
