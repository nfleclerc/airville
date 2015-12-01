package airville.core.gamepieces.counters;

import airville.core.passengers.PassengerGroup;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A Regular Counter that can process passengers. Passengers in this line can be of any type, and
 * Passengers that are alone and frequent flyers are always processed first.
 */
public class RegularCounter extends Counter {

	/**
	 * Instantiates a new RegularCounter.
	 */
	public RegularCounter(){
		super();
	}

	/**
	 * Process all the Passengers in this line. Frequent flyers are always processed first
	 * and passengers can be of any type.
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
	 * Creates a new queue for this class to use. Moves all the solo frequent flyers
	 * to the head of the line.
	 * @return An adjusted line with the frequent flyers at the head.
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

