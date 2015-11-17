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

	private Player(){
		points = 0;
		diamonds = 0;

		//numbers of resources to start with
		numberOfAgents = STARTING_AGENT_COUNT;
		numberOfRegularCounters = STARTING_REGCOUNTER_COUNT;
		numberOfAutoCounters = STARTING_AUTOCOUNTER_COUNT;
		numberOfSupervisors = STARTING_SUPERVISOR_COUNT;

	}

	public static Player getInstance(){
		return instance;
	}	

	public void moveSupervisor(Supervisor supervisor){
	}

	public void addPoints(int points){
		this.points += points;
	}

	public void removePoints(int points){
		this.points -= points;
	}


	public void removeDiamonds(int diamonds) {
		this.diamonds -= diamonds;
	}
}
