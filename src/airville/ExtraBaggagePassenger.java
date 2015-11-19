package airville;

public class ExtraBaggagePassenger extends AbstractPassenger {

	private static final int EXTRABAGGAGE_SPEED = 4;
	private static final int EXTRABAGGAGE_POINTS = 5;

	ExtraBaggagePassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		//alters the speed so this passenger is processed slower
		counter.setProcessSpeed(counter.getProcessSpeed() / EXTRABAGGAGE_SPEED);
		Player.getInstance().addPoints(EXTRABAGGAGE_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * EXTRABAGGAGE_SPEED);
	}

	public static int getPointValue() {
		return EXTRABAGGAGE_POINTS;
	}
}
