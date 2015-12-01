package airville.core.gamepieces.counters;

import airville.core.passengers.PassengerGroup;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 */
public class RegularCounter extends Counter {

	/**
	 *
	 */
	public RegularCounter(){
		super();
	}

	/**
	 *
	 */
	@Override
	public void processPassengers() {
		busy = true;
		Queue<PassengerGroup> adjustedLine = moveFrequentFlyers();
		while (!adjustedLine.isEmpty()){
			adjustedLine.poll().processAt(this);
		}
		setBusyTime(0);
		busy = false;
	}

	/**
	 *
	 * @return
	 */
	private Queue<PassengerGroup> moveFrequentFlyers(){
		Iterator iterator = getLine().iterator();
		Queue<PassengerGroup> adjustedLine = new PriorityQueue<>();
		while (iterator.hasNext()){
			PassengerGroup currentGroup = (PassengerGroup) iterator.next();
			if (currentGroup.isOnePassenger() && currentGroup.getPassengers().get(0).isFrequentFlyer()){
				adjustedLine.add(currentGroup);
			}
		}
		getLine().stream().forEach(passengerGroup -> adjustedLine.add(passengerGroup));
		getLine().clear();
		return adjustedLine;
	}
}

