package airville.core.gamepieces.counters;

import airville.core.gamepieces.GamePieceType;
import airville.core.passengers.PassengerGroup;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * A Regular Counter that can process passengers. Passengers are always processed with
 * their group. Passengers in this line can be of any type, and
 * Passengers that are frequent flyers are processed first.
 */
public class RegularCounter extends Counter {

	/**
	 * Instantiates a new RegularCounter.
	 */
	public RegularCounter(){
		super();
	}

	/**
	 * Process all the Passengers in this line. Frequent flyers are processed first
	 * and passengers can be of any type.
	 */
	@Override
	public void processPassengers() {
		//this counter is busy and is processing passengers
		setBusy();
		//process while there are still passengers in the list
		while (!getLine().isEmpty()) {
			//move all the frequent flyers to the head of the line
			Queue<PassengerGroup> adjustedLine = moveFrequentFlyers();
			//process all the passengers in the new line
			while (!adjustedLine.isEmpty()) {
				adjustedLine.poll().processAt(this);
			}
		}
		//this counter is no longer busy
		setBusyTime(0);
		setFree();
	}

	/**
	 * Creates a new queue for this class to use. Moves all the frequent flyers
	 * to the head of the line.
	 * @return An adjusted line with the frequent flyers at the head.
	 */
	private Queue<PassengerGroup> moveFrequentFlyers(){
		Iterator iterator = getLine().iterator();
		Queue<PassengerGroup> adjustedLine = new PriorityQueue<>();
		while (iterator.hasNext()){
			//iterate through the original line
			PassengerGroup currentGroup = (PassengerGroup) iterator.next();
			if (currentGroup.isOfFrequentFlyers()){
				//if the passenger is a frequent flyer add them into the new line
				//and removes them from the old line
				adjustedLine.add(currentGroup);
				getLine().remove(currentGroup);
			}
		}
		//add the remaining passengers into the line. all the frequent flyers
		//will be at the front of the line
		getLine().stream().forEach(adjustedLine::add);
		//remove the passengers from the original line and return the new queue
		getLine().clear();
		return adjustedLine;
	}

	@Override
	public GamePieceType getGamePieceType() {
		return GamePieceType.REG_COUNTER;
	}
}

