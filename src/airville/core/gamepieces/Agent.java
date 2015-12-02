package airville.core.gamepieces;

import airville.core.Airport;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;

/**
 * An Agent walking around the Automatic Counters that can be called to help.
 */
public class Agent implements GamePiece {

	private boolean busy;
	private double busyTime;

	/**
	 * Static method that returns an agent that is willing to help a group of Passengers.
	 * Removes the agent from the list of
	 * free agents that is maintained in the Airport class.
	 * @param passengerGroupToHelp The group of passengers this agent is going to help.
	 * @return The Agent that is going to help the group.
	 */
	public static Agent callForAssistance(PassengerGroup passengerGroupToHelp){
		//returns an agent and removes it from the pool of agents just floating around
		Agent agent =
				//just grabs a random agent that's floating around
				Airport.getInstance().getAgents().get((int) (Math.random() *
						Airport.getInstance().getAgents().size()));

		Airport.getInstance().getAgents().remove(agent);
		//sets that agent to be busy
		agent.setBusy();
		agent.setBusyTime(passengerGroupToHelp.size() * PassengerType.REGULAR.getBusyTime());
		return agent;
	}

	/**
	 * Tells the agent to leave the counter after helping the group. Adds an Agent
	 * back to the list of free agents that is maintained by the Airport.
	 */
	public void leaveCounter(){
		//the agent leaves the counter and returns to floating around
		Airport.getInstance().addItem(this);
		setBusyTime(0);
		setFree();
	}

	@Override
	public boolean isBusy(){
		return this.busy;
	}

	@Override
	public double getBusyTime(){
		return this.busyTime;
	}

	@Override
	public void setBusyTime(double busyTime) {
		this.busyTime = busyTime;
	}

	@Override
	public GamePieceType getGamePieceType() {
		return GamePieceType.AGENT;
	}

	@Override
	public void setBusy(){
		this.busy = true;
	}

	@Override
	public void setFree(){
		this.busy = false;
	}

}

