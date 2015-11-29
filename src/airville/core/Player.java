package airville.core;

import airville.core.gamepieces.PurchasableGamePieceType;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.Counter;

import java.util.Optional;

/**
 *
 */
public class Player {

	private static final int STARTING_AGENT_COUNT = 2;
	private static final int STARTING_SUPERVISOR_COUNT = 1;
	private static final int STARTING_AUTOCOUNTER_COUNT = 4;
	private static final int STARTING_REGCOUNTER_COUNT = 4;


	private int points;
	private int diamonds;
	private int numberOfAgents;
	private int numberOfRegularCounters;
	private int numberOfAutoCounters;
	private int numberOfSupervisors;

	private static final Player instance = new Player();

	/**
	 *
	 */
	private Player(){
		points = 0;
		diamonds = 0;

		//numbers of resources to start with
		numberOfAgents = STARTING_AGENT_COUNT;
		numberOfRegularCounters = STARTING_REGCOUNTER_COUNT;
		numberOfAutoCounters = STARTING_AUTOCOUNTER_COUNT;
		numberOfSupervisors = STARTING_SUPERVISOR_COUNT;

	}

	/**
	 *
	 * @return
	 */
	public static Player getInstance(){
		return instance;
	}

	/**
	 *
	 * @param supervisor
	 * @param counter
	 */
	public void moveSupervisor(Supervisor supervisor, Counter counter){
		//removes the speed buff from the counter that the supervisor is leaving
		supervisor.slowDown(supervisor.getCurrentCounter());
		//removes the supervisor from the counter he/she is currently at
		supervisor.getCurrentCounter().setSupervisor(Optional.empty());

		//sets supervisor to be at the counter
		counter.setSupervisor(Optional.of(supervisor));
		//applies the supervisor speed buff to the new counter
		supervisor.speedUp(counter);
		//passes a reference of the new counter to the supervisor
		supervisor.setCurrentCounter(Optional.of(counter));
		//the supervisor is as busy as long as the counter their at
		supervisor.setBusyTime(counter.getBusyTime());
	}

	/**
	 *
	 * @param gamePieceType
	 */
	public void increaseCountOf(PurchasableGamePieceType gamePieceType){
		switch (gamePieceType) {
			case AGENT:
				this.numberOfAgents++;
				break;
			case SUPERVISOR:
				this.numberOfSupervisors++;
				break;
			case REG_COUNTER:
				this.numberOfRegularCounters++;
				break;
			case AUTO_COUNTER:
				this.numberOfAutoCounters++;
				break;
		}
	}

	/**
	 *
	 * @param points
	 */
	public void addPoints(int points){
		this.points += points;
	}

	/**
	 *
	 * @param points
	 */
	public void removePoints(int points){
		this.points -= points;
	}

	/**
	 *
	 * @param diamonds
	 */
	public void removeDiamonds(int diamonds) {
		this.diamonds -= diamonds;
	}

	/**
	 *
	 */
	public void addDiamond(){
		this.diamonds++;
	}

	/**
	 *
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 *
	 * @return
	 */
	public int getDiamonds() {
		return diamonds;
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfAgents() {
		return numberOfAgents;
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfRegularCounters() {
		return numberOfRegularCounters;
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfAutoCounters() {
		return numberOfAutoCounters;
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfSupervisors() {
		return numberOfSupervisors;
	}

	/**
	 *
	 */
	public void resetCurrencies(){
		points = 0;
		diamonds = 0;
	}
}
