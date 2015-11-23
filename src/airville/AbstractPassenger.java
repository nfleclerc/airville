package airville;

import java.util.Optional;

public abstract class AbstractPassenger implements Passenger, GamePiece{

	private Optional<PassengerGroup> group;
	private boolean frequentFlyer;
	private PassengerType passengerType;

	//factory method returns different subclasses based on enum
	public static Passenger make(PassengerType passengerType, boolean frequentFlyer){
		return (Passenger) passengerType.getConstructor().apply(frequentFlyer);
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
		this.group = Optional.of(group);
	}

	@Override
	public boolean isInGroup(){
		return group.isPresent();
	}

	@Override
	public PassengerGroup getGroup(){
		return group.get();
	}

	@Override
	public boolean isFrequentFlyer(){
		return this.frequentFlyer;
	}

	protected void setPassengerType(PassengerType passengerType){
		this.passengerType = passengerType;
	}

	@Override
	public PassengerType getPassengerType(){
		return this.passengerType;
	}

}
