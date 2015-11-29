package airville.gamepieces.counters;

import airville.*;
import airville.gamepieces.Agent;
import airville.passengers.PassengerGroup;

import java.util.Optional;
import java.util.PriorityQueue;

public class AutomaticCounter extends Counter {

	private static final double PROBABILITY_PASSENGER_REQ_HELP = 0.5;
	private Optional<Agent> agent;

	public AutomaticCounter(){
		super();
	}

	public void setAgent(Agent agent) {
		this.agent = Optional.of(agent);
	}

	@Override
	public void processPassengers() {
		while (!line.isEmpty()){
			if (line.peek().isOfRegularPassengers()){
				line.poll().processAt(this);
			} else {
				line.poll().queueAt(Airport.getInstance().getRandomRegularCounter());
			}
		}
	}

}
