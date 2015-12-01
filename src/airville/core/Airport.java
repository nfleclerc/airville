package airville.core;

import airville.core.gamepieces.Agent;
import airville.core.gamepieces.PurchasableGamePieceType;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Airport {

	//holds all the characters and counters in the game
	private List<RegularCounter> regularCounters = new ArrayList<>();
	private List<AutomaticCounter> automaticCounters = new ArrayList<>();
	private List<Agent> agents = new ArrayList<>();
	private List<Supervisor> supervisors = new ArrayList<>();

	private static final Player player = Player.getInstance();
	private static final Store store = Store.getInstance();

	private static final Airport instance = new Airport();

	private Airport(){
	 /*to prevent instantiation*/
	}

	/**
	 *
	 * @return
	 */
	public static Airport getInstance(){
		return instance;
	}

	/**
	 *
	 * @param gamePieceType
	 */
	public void addItem(PurchasableGamePieceType gamePieceType){
		switch (gamePieceType) {
			case AGENT:
				agents.add((Agent) gamePieceType.getConstructor().get());
				break;
			case SUPERVISOR:
				supervisors.add((Supervisor) gamePieceType.getConstructor().get());
				break;
			case REG_COUNTER:
				regularCounters.add((RegularCounter) gamePieceType.getConstructor().get());
				break;
			case AUTO_COUNTER:
				automaticCounters.add((AutomaticCounter) gamePieceType.getConstructor().get());
				break;
		}
	}

	/**
	 *
	 * @return
	 */
	public RegularCounter getRandomRegularCounter(){
		return (regularCounters.get((int) (Math.random() * regularCounters.size())));
	}

	/**
	 *
	 * @return
	 */
	public List<RegularCounter> getRegularCounters() {
		return regularCounters;
	}

	/**
	 *
	 * @return
	 */
	public List<AutomaticCounter> getAutomaticCounters() {
		return automaticCounters;
	}

	/**
	 *
	 * @return
	 */
	public List<Agent> getAgents() {
		return agents;
	}

	/**
	 *
	 * @return
	 */
	public List<Supervisor> getSupervisors(){
		return supervisors;
	}

	/**
	 *
	 */
	public void clearLists(){
		regularCounters.clear();
		automaticCounters.clear();
		agents.clear();
		supervisors.clear();
	}
}
