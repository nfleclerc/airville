import java.util.Random;

public class FloatingAgent {

	public static FloatingAgent callForAssistanceAt(AutomaticCounter counter){
		FloatingAgent agent =
				GamePieces.getFloatingAgents().get((int) (Math.random() * GamePieces.getFloatingAgents().size()));
		GamePieces.getFloatingAgents().remove(agent);
		return agent;
	}

	public void leaveCounter(AutomaticCounter counter){
		counter.setAgent(null);
		GamePieces.addFloatingAgent(this);
	}

}

