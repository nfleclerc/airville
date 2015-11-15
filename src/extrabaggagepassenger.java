public class ExtraBaggagePassenger extends AbstractPassenger {

	private static int final EXTRABAGGAGE_SPEED = 4;

	@Override
	public void processAt(Counter counter){
		counter.setProcessSpeed(counter.getProcessSpeed() / EXTRABAGGAGE_SPEED);
		Player.getInstance().addPoints(EXTRABAGGAGE_POINTS);
		counter.setProcessSpeed(counter.getProcessSpeed() * EXTRABAGGAGE_SPEED);
	}

}
