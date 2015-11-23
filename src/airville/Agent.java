package airville;

public class Agent implements GamePiece {

	public static Agent callForAssistanceAt(AutomaticCounter counter){
		//returns an agent and removes it from the pool of agents just floating around
		Agent agent =
				//just grabs a random agent thats floating around
				Airport.getInstance().getAgents().get((int) (Math.random() *
						Airport.getInstance().getAgents().size()));

		Airport.getInstance().getAgents().remove(agent);
		return agent;
	}

	public void leaveCounter(AutomaticCounter counter){
		//the agent leaves the counter and returns to floating around
		counter.setAgent(null);
		Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
	}

}

