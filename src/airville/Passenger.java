package airville;

public interface Passenger {

	void processAt(Counter counter);

	void queueAt(Counter counter);

	boolean isFrequentFlyer();

	boolean isInGroup();

	PassengerGroup getGroup();

	void setInGroup(boolean inGroup);

	void setGroup(PassengerGroup group);

}
