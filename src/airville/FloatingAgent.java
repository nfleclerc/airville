package airville;

public class FloatingAgent {

	public static FloatingAgent callForAssistanceAt(AutomaticCounter counter){
		//returns an agent and removes it from the pool of agents just floating around
		FloatingAgent agent =
				//just grabs a random agent thats floating around
				GamePieces.getFloatingAgents().get((int) (Math.random() * GamePieces.getFloatingAgents().size()));
		GamePieces.getFloatingAgents().remove(agent);
		return agent;
	}

	public void leaveCounter(AutomaticCounter counter){
		//the agent leaves the counter and returns to floating around
		counter.setAgent(null);
		GamePieces.addFloatingAgent(this);
	}

}

