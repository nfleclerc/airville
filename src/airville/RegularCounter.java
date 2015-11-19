package airville;

public class RegularCounter extends Counter {

	public static final int FRONT_INDEX = 0;

	@Override
	public void processPassengers() {
		// move all freqflyers to the front
		moveFrequentFlyers();
		//process each passenger in line then remove it
		for (Passenger passenger : getPassengersInLine()){
			passenger.processAt(this);
			getPassengersInLine().remove(passenger);
		}
	}

	private void moveFrequentFlyers(){
		//check each passenger in the line and if he/she is a
		//fregflyer, move him/her to the front of the line
		for (Passenger passenger : getPassengersInLine()){
			if (passenger.isFrequentFlyer()){
				getPassengersInLine().remove(passenger);
				getPassengersInLine().add(FRONT_INDEX, passenger);
			}
		}
	}

}

