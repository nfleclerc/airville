package airville;

import java.util.LinkedList;
import java.util.List;

public class AutomaticCounter extends Counter {

	private static final double PROBABILITY_PASSENGER_REQ_HELP = 0.5;
	private Agent agent;

	private List<Passenger> adjustedLine;

	public AutomaticCounter(){
		super();
		agent = null;
		adjustedLine = new LinkedList<>();
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	@Override
	public void processPassengers() {
		//check each passenger in line
		for (Passenger passenger : getPassengersInLine()){
			//if the passenger is just a normal passenger and doest need special
			//assistance, so check if he/she is in a group
			if (passenger.getPassengerType() == PassengerType.REGULAR){
				processPassengersInGroups(passenger);
			} else {
				//this passenger needs special assistance
				//remove them from the line and queue them at a
				//non automatic counter

				//this passenger will not be added to the new line
				passenger.queueAt(Airport.getInstance().getRandomRegularCounter());
			}
		}

		processAdjustedLine();
	}

	private void processPassengersInGroups(Passenger passenger){
		//check if the passenger is in a group
		if (!passenger.isInGroup()){
			//if by themselves this passenger can just be processed
			processPassenger(passenger);
		} else {
			//this passenger is in a group
			//check each member of his/her group to see if any need special help
			if (!checkGroupForSpecialPassengers(passenger.getGroup())){
				//if none need special help, he/she can be processed as normal
				processPassenger(passenger);
			} else {
				//someone in the group needs assistance
				//remove the whole group from the line and queue them
				//all at the same regular counter

				//this passenger will not be in the new line
				passenger.getGroup().queueAt(Airport.getInstance().getRandomRegularCounter());
			}
		}
	}

	private boolean checkGroupForSpecialPassengers(PassengerGroup group){
		//check each passenger in a group
		//if any of them are not regular, return true
		for (Passenger passenger : group.getPassengers()){
			if (!(passenger.getPassengerType() == PassengerType.REGULAR)){
				return true;
			}
		}
		return false;
	}

	private void processPassenger(Passenger passenger){
		//randomly select with 50% probability if a passenger needs help
		//from an agent while at an automatic check in counter
		if (Math.random() > PROBABILITY_PASSENGER_REQ_HELP){
			//the passenger doesn't need help
			//process him/her and remove him/her from the line
			adjustedLine.add(passenger);
			//getPassengersInLine().remove(passenger);
		} else {
			//the passenger could use some assistance
			//call an agent over, set this as this counter's current agent
			agent = Agent.callForAssistanceAt(this);
			//the agent came over, this passenger can be processed normally
			adjustedLine.add(passenger);
			//getPassengersInLine().remove(passenger);
			//the agent that came over can leave the counter and he/she
			//can go back to roaming about
			agent.leaveCounter(this);
		}
	}

	private void processAdjustedLine(){
		for (Passenger passenger : adjustedLine){
			passenger.processAt(this);
		}

		//reset the new list
		//and clear the old line
		adjustedLine = new LinkedList<>();
		clearLine();
	}

}
