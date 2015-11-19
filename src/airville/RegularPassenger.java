package airville;

public class RegularPassenger extends AbstractPassenger{

	private static final int REGULAR_POINTS = 1;

	RegularPassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		Player.getInstance().addPoints(REGULAR_POINTS);
	}

	public static int getPointValue() {
		return REGULAR_POINTS;
	}

}	
