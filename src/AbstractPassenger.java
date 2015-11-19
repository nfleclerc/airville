public abstract class AbstractPassenger implements Passenger{

	private PassengerGroup group;
	private boolean frequentFlyer;
	private boolean inGroup;

	//the points each passenger adds
	protected static final int REGULAR_POINTS = 1;
	protected static final int REROUTED_POINTS = 15;
	protected static final int EXTRABAGGAGE_POINTS = 5;
	protected static final int OVERBOOKED_POINTS = 10;


	//factory method returns different subclasses based on enum
	public static Passenger make(PassengerType passengerType, boolean frequentFlyer){
		return (Passenger) passengerType.getConstructor();
	}

	AbstractPassenger(boolean frequentFlyer){
		this.frequentFlyer = frequentFlyer;
	}

	@Override
	public void queueAt(Counter counter){
		counter.getPassengersInLine().add(this);
	}

	@Override
	public void setGroup(PassengerGroup group){
		this.group = group;
	}

	@Override
	public void setInGroup(boolean inGroup){
		this.inGroup = inGroup;
	}

	@Override
	public boolean isInGroup(){
		return this.inGroup;
	}

	@Override
	public PassengerGroup getGroup(){
		return this.group;
	}

	@Override
	public boolean isFrequentFlyer(){
		return this.frequentFlyer;
	}

}
