package airville;

import java.util.LinkedList;
import java.util.List;

public class RegularCounter extends Counter {

	public static final int FRONT_INDEX = 0;

	public RegularCounter(){
		super();
	}

	@Override
	public void processPassengers() {
		// move all freqflyers to the front
		List<Passenger> freqFlyerAdjustedLine = moveFrequentFlyers();
		//process each passenger in line then remove it
		for (Passenger passenger : freqFlyerAdjustedLine){
			passenger.processAt(this);
			getPassengersInLine().remove(passenger);
		}
	}

	private List<Passenger> moveFrequentFlyers(){
		//check each passenger in the line and if he/she is a
		//fregflyer, move him/her to the front of the line

		List<Passenger> freqFlyerList = new LinkedList<>();

		for (Passenger passenger : getPassengersInLine()){
			if (passenger.isFrequentFlyer()){
				freqFlyerList.add(passenger);
				getPassengersInLine().remove(passenger);
			}
		}
		getPassengersInLine().stream().forEach(passenger -> freqFlyerList.add(passenger));
		return freqFlyerList;
	}

}

