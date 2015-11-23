package airville;

public interface Passenger {

	void processAt(Counter counter);

	void queueAt(Counter counter);

	boolean isFrequentFlyer();

	boolean isInGroup();

	PassengerGroup getGroup();

	void setGroup(PassengerGroup group);

	PassengerType getPassengerType();

}
