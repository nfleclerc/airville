package airville.core;

import airville.core.gamepieces.Agent;
import airville.core.gamepieces.GamePiece;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;

import java.util.ArrayList;
import java.util.List;

/**
 * The Airport. This class is a singleton and holds information on all the game pieces currently in the game.
 */
public class Airport {

	//holds all the characters and counters in the game
	private List<RegularCounter> regularCounters = new ArrayList<>();
	private List<AutomaticCounter> automaticCounters = new ArrayList<>();
	private List<Agent> agents = new ArrayList<>();
	private List<Supervisor> supervisors = new ArrayList<>();

	private static final Airport instance = new Airport();

	private Airport(){
	 /*to prevent instantiation*/
	}

	/**
	 * Returns the single instance of the Airport.
	 * @return The instance of the Airport.
	 */
	public static Airport getInstance(){
		return instance;
	}

	/**
	 * Adds a game piece to the correct list and game depending on what kind of type
	 * piece it is.
	 * @param gamePiece The type of the game piece to be added.
	 */
	public void addItem(GamePiece gamePiece){
		switch (gamePiece.getGamePieceType()) {
			case AGENT:
				agents.add((Agent) gamePiece);
				break;
			case SUPERVISOR:
				supervisors.add((Supervisor) gamePiece);
				break;
			case REG_COUNTER:
				regularCounters.add((RegularCounter) gamePiece);
				break;
			case AUTO_COUNTER:
				automaticCounters.add((AutomaticCounter) gamePiece);
				break;
		}
	}

	/**
	 * Returns a random RegularCounter from the list of RegularCounters.
	 * @return A Regular Counter.
	 */
	public RegularCounter getRandomRegularCounter(){
		return (regularCounters.get((int) (Math.random() * regularCounters.size())));
	}

	/**
	 * Returns the list of Regular Counters.
	 * @return A List of Regular Counters.
	 */
	public List<RegularCounter> getRegularCounters() {
		return regularCounters;
	}

	/**
	 * Returns the list of Automatic Counters.
	 * @return A List of Automatic Counters.
	 */
	public List<AutomaticCounter> getAutomaticCounters() {
		return automaticCounters;
	}

	/**
	 * Returns the list of Agents.
	 * @return A List of Agents.
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	/**
	 * Returns the List of Supervisors.
	 * @return A List of Supervisors.
	 */
	public List<Supervisor> getSupervisors(){
		return supervisors;
	}

	/**
	 * Resets the contents of each list within the Airport.
	 */
	public void clearLists(){
		regularCounters.clear();
		automaticCounters.clear();
		agents.clear();
		supervisors.clear();
	}
}
