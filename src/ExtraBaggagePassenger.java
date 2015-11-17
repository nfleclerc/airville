public class ExtraBaggagePassenger extends AbstractPassenger {

	private static final int EXTRABAGGAGE_SPEED = 4;

	ExtraBaggagePassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() / EXTRABAGGAGE_SPEED);
		Player.getInstance().addPoints(EXTRABAGGAGE_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * EXTRABAGGAGE_SPEED);
	}

}
