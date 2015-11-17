public class RegularPassenger extends AbstractPassenger{

	RegularPassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		Player.getInstance().addPoints(REGULAR_POINTS);
	}

}	
