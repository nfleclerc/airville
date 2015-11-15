public class AbstractPassenger implements Passenger{

	private PassengerGroup group;
	private boolean freqFlyer;
	private boolean inGroup;
	private static final int REGULAR_POINTS = 1;
	private static final int REROUTED_POINTS = 15;
	private static final int EXTRABAGGAGE_POINTS = 5;
	private static final int OVERBOOKED_POINTS = 10;


	public static Passenger make (PassengerType passengerType){
		passengerType.getConstructor().get();
	}

	@Override
	public void queueAt(Counter counter){
		counter.getPassengersInLine().add(this);
	}

}
