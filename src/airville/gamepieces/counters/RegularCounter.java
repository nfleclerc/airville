package airville.gamepieces.counters;

import airville.passengers.PassengerGroup;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class RegularCounter extends Counter {


	public RegularCounter(){
		super();
	}

	@Override
	public void processPassengers() {
		//move all freq flyers to the front of the line
		//process all passengers
	}

	private Queue<PassengerGroup> moveFrequentFlyers(){
		Iterator iterator = line.iterator();
		Queue<PassengerGroup> adjustedLine = new PriorityQueue<>();
		while (iterator.hasNext()){

		}
		return adjustedLine;
	}
}

