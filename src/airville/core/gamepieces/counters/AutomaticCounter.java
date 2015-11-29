package airville.core.gamepieces.counters;

import airville.core.Airport;
import airville.core.gamepieces.Agent;

import java.util.Optional;

public class AutomaticCounter extends Counter {

	private static final double PROBABILITY_PASSENGER_REQ_HELP = 0.5;
	private Optional<Agent> agent;

	public AutomaticCounter(){
		super();
	}

	@Override
	public void processPassengers() {
		busy = true;
		while (!getLine().isEmpty()){
			if (getLine().peek().isOfRegularPassengers()){
				if (Math.random() > PROBABILITY_PASSENGER_REQ_HELP){
					agent = Optional.of(Agent.callForAssistance(getLine().peek()));
					getLine().poll().processAt(this);
					agent.get().leaveCounter();
					agent = Optional.empty();
				} else {
					getLine().poll().processAt(this);
				}
			} else {
				getLine().poll().queueAt(Airport.getInstance().getRandomRegularCounter());
			}
		}
		setBusyTime(0);
		busy = false;
	}

}
