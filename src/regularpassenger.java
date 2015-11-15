public class RegularPassenger extends AbstractPassenger{

	@Override
	public void processAt(Counter counter){
		Player.getInstance().addPoints(REGULAR_POINTS);
	}

}	
