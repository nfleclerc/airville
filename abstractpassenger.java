public class AbstractPassenger{

	private PassengerGroup group;
	private boolean freqFlyer;
	private boolean inGroup;
	private static final player = Player.getInstance();

	public static Passenger make (PassengerType passengerType){
		passengerType.getConstructor().get();
	}

	@Override
	public void queueAt(Counter counter){
		counter.getPassengersInLine().add(this);
	}

}
