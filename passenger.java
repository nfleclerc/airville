public interface Passenger {

	void processAt(Counter counter);

	void queueAt(Counter counter);

	boolean isFrequentFlyer();

}
