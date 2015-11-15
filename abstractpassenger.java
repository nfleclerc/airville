public class AbstractPassenger{

	private PassengerGroup group;
	private boolean freqFlyer;
	private boolean inGroup;

	public static Passenger make (PassengerType passengerType){
	}

	@Override
	public void queueAt(Counter counter){
		counter.getPassengersInLine().add(this);
	}

}
