package airville.core.gamepieces.counters;

import airville.core.Airport;
import airville.core.gamepieces.Agent;
import airville.core.gamepieces.GamePieceType;

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
	 * Process all the Passengers in its line. Randomly decides if a passenger group needs help
	 * from an agent. If it does it calls a free agent over. If the passenger group does not only contain
	 * Regular Passengers is removes them from the line and queues them at a regular counter.
	 */
	@Override
	public void processPassengers() {
		//this counter is busy
		setBusy();
		while (!getLine().isEmpty()){
			//process the passengers while there are still passengers in this line
			if (getLine().peek().isOfRegularPassengers()){
				//all the passengers in this line are regular
				if (Math.random() > PROBABILITY_PASSENGER_REQ_HELP){
					//this group of passengers has been randomly selected
					//to require help from an agent
					//call an agent over then process it
					agent = Optional.of(Agent.callForAssistance(getLine().peek()));
					getLine().poll().processAt(this);
					//the passenger has been processed and the agent can leave
					//this counter
					agent.get().leaveCounter();
					agent = Optional.empty();
				} else {
					//the passenger doesn't require help and can go about
					//its business as normal
					getLine().poll().processAt(this);
				}
			} else {
				//this group is not made of all regular passengers
				//remove this group from this counter and
				//queue it at a regular counter
				getLine().poll().queueAt(Airport.getInstance().getRandomRegularCounter());
			}
		}
		//this counter is no longer busy
		setBusyTime(0);
		setFree();
	}


	@Override
	public GamePieceType getGamePieceType() {
		return GamePieceType.AUTO_COUNTER;
	}
}
