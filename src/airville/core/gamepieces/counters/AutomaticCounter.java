package airville.core.gamepieces.counters;

import airville.core.Airport;
import airville.core.gamepieces.Agent;

import java.util.Optional;

/**
 * An Automatic Counter to process Passengers. Can only process Regular Passengers and does
 * so regardless if they are frequent flyers or not.
 */
public class AutomaticCounter extends Counter {

	private static final double PROBABILITY_PASSENGER_REQ_HELP = 0.5;
	private Optional<Agent> agent;

	/**
	 * Instantiates a new AutomaticCounter.
	 */
	public AutomaticCounter(){
		super();
	}

	/**
	 * Process all the Passenegers in its line. Randomly decides if a passenger group needs help
	 * from an agent. If it does it calls a free agent over. If the passenger group does not only contain
	 * Regular Passengers is removes them from the line and queues them at a regular counter.
	 */
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
