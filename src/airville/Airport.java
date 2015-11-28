package airville;

import airville.gamepieces.Agent;
import airville.gamepieces.PurchasableGamePieceType;
import airville.gamepieces.Supervisor;
import airville.gamepieces.counters.AutomaticCounter;
import airville.gamepieces.counters.RegularCounter;

import java.util.ArrayList;
import java.util.List;

public class Airport {

	//holds all the characters and counters in the game
	private List<RegularCounter> regularCounters = new ArrayList<>();
	private List<AutomaticCounter> automaticCounters = new ArrayList<>();
	private List<Agent> agents = new ArrayList<>();
	private List<Supervisor> supervisors = new ArrayList<>();

	private static final Player player = Player.getInstance();
	private static final Store store = Store.getInstance();

	private static final Airport instance = new Airport();

	private Airport(){ /*to prevent instantiation*/ }

	public static Airport getInstance(){
		return instance;
	}

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

	public RegularCounter getRandomRegularCounter(){
		return (regularCounters.get((int) (Math.random() * regularCounters.size())));
	}

	public List<RegularCounter> getRegularCounters() {
		return regularCounters;
	}

	public List<AutomaticCounter> getAutomaticCounters() {
		return automaticCounters;
	}

	public List<Agent> getAgents() {
		return agents;
	}

	public List<Supervisor> getSupervisors() {
		return supervisors;
	}

	public  void clearLists(){
		regularCounters = new ArrayList<>();
		automaticCounters = new ArrayList<>();
		agents = new ArrayList<>();
		supervisors = new ArrayList<>();
	}
}
