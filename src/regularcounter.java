public class RegularCounter extends Counter {

	public static final int FRONT_INDEX = 0;

	@Override
	public void processPassengers() {
		// move all freqflyers to the front
		moveFrequentFlyers();
		for (Passenger passenger : passengersInLine){
			passenger.processAt(this);
			passengersInlIne.remove(passenger);
		}
	}

	private void moveFrequentFlyers(){
		for (Passenger passenger : passengersInLine){
			if (passenger.isFrequentFlyer()){
				passengersInLine.remove(passenger);
				passengersInLine.add(FRONT_INDEX, passenger);
			}
		}
	}

}

