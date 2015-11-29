package airville.gamepieces;

import airville.Airport;
import airville.gamepieces.counters.AutomaticCounter;
import airville.passengers.Passenger;
import airville.passengers.PassengerGroup;
import airville.passengers.PassengerType;

public class Agent implements GamePiece {

	private boolean busy;
	private double busyTime;

	public static Agent callForAssistance(PassengerGroup passengerGroupToHelp){
		//returns an agent and removes it from the pool of agents just floating around
		Agent agent =
				//just grabs a random agent thats floating around
				Airport.getInstance().getAgents().get((int) (Math.random() *
						Airport.getInstance().getAgents().size()));

		Airport.getInstance().getAgents().remove(agent);
		agent.busy = true;
		agent.busyTime = passengerGroupToHelp.size() * PassengerType.REGULAR.getBusyTime();
		return agent;
	}

	public void leaveCounter(){
		//the agent leaves the counter and returns to floating around
		Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
		busyTime = 0;
		busy = false;
	}

	@Override
	public boolean isBusy(){
		return this.busy;
	}

	@Override
	public double getBusyTime(){
		return this.busyTime;
	}

}

