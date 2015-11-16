public class RegularCounter extends Counter {

	public static final int FRONT_INDEX = 0;

	@Override
	public void processPassengers() {
		// move all freqflyers to the front
		moveFrequentFlyers();
		for (Passenger passenger : getPassengersInLine()){
			passenger.processAt(this);
			getPassengersInLine().remove(passenger);
		}
	}

	private void moveFrequentFlyers(){
		for (Passenger passenger : getPassengersInLine()){
			if (passenger.isFrequentFlyer()){
				getPassengersInLine().remove(passenger);
				getPassengersInLine().add(FRONT_INDEX, passenger);
			}
		}
	}

}

