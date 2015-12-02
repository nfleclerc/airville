package airville.core;

import airville.core.gamepieces.GamePieceType;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.Counter;

import java.util.Optional;

/**
 * Represents the Player within the game. A singleton Class.
 */
public class Player {

	private static final int STARTING_AGENT_COUNT = 2;
	private static final int STARTING_SUPERVISOR_COUNT = 1;
	private static final int STARTING_AUTOCOUNTER_COUNT = 4;
	private static final int STARTING_REGCOUNTER_COUNT = 4;
	private static final int STARTING_DIAMONDS = 0;
	private static final int STARTING_POINTS = 0;


	private int points;
	private int diamonds;
	private int numberOfAgents;
	private int numberOfRegularCounters;
	private int numberOfAutoCounters;
	private int numberOfSupervisors;

	private static final Player instance = new Player();

	/**
	 * Creates a new Player for the game.
	 */
	private Player(){
		points = STARTING_POINTS;
		diamonds = STARTING_DIAMONDS;
		numberOfAgents = STARTING_AGENT_COUNT;
		numberOfRegularCounters = STARTING_REGCOUNTER_COUNT;
		numberOfAutoCounters = STARTING_AUTOCOUNTER_COUNT;
		numberOfSupervisors = STARTING_SUPERVISOR_COUNT;

	}

	/**
	 * Returns an instance of the Player.
	 * @return an instance of the Player
	 */
	public static Player getInstance(){
		return instance;
	}

	/**
	 * Moves a Supervisor from one Counter to another.
	 * @param supervisor The Supervisor that is being moved.
	 * @param counter The Counter the Supervisor is being moved to.
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
	 * Increases the count of resources the Player has. This is to keep track of
	 * the Players total resources so the game can be saved, quit, and then resumed
	 * without the Player having to restart.
	 * @param gamePieceType The type of game piece to add to the Player's count of.
	 */
	public void increaseCountOf(GamePieceType gamePieceType){
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
	 * Adds a specified number of points to the Player's total points.
	 * @param points The number of points to add to the Player's total.
	 */
	public void addPoints(int points){
		this.points += points;
	}

	/**
	 * Removes a number of points from the Player. This is used for buying items.
	 * @param points The points to remove from the Player's total.
	 */
	public void removePoints(int points){
		this.points -= points;
	}

	/**
	 * Removes a number of diamonds from the Player.
	 * @param diamonds The diamonds to remove from the Player.
	 */
	public void removeDiamonds(int diamonds) {
		this.diamonds -= diamonds;
	}

	/**
	 * Adds a diamond to the Player's total.
	 */
	public void addDiamond(){
		this.diamonds++;
	}

	/**
	 * Returns the Player's total points.
	 * @return An int of the Player's total points.
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Returns the number of diamonds the Player has.
	 * @return The Player's total number of diamonds.
	 */
	public int getDiamonds() {
		return diamonds;
	}

	/**
	 * Returns the number of Agents the Player has.
	 * @return The number of Agents the Player has.
	 */
	public int getNumberOfAgents() {
		return numberOfAgents;
	}

	/**
	 * Returns the number of Regular Counters the Player has.
	 * @return  The number of Regular Counters the Player has.
	 */
	public int getNumberOfRegularCounters() {
		return numberOfRegularCounters;
	}

	/**
	 * Returns the number of Automatic Counters the Player has.
	 * @return The number of Automatic COunters the Player has.
	 */
	public int getNumberOfAutoCounters() {
		return numberOfAutoCounters;
	}

	/**
	 * Returns the number of Supervisors the Player has.
	 * @return The number of Supervisors the Player has.
	 */
	public int getNumberOfSupervisors() {
		return numberOfSupervisors;
	}

	/**
	 * Resets the number of points and diamonds the Player has.
	 */
	public void resetCurrencies(){
		points = 0;
		diamonds = 0;
	}
}
