package airville;

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

	public void moveSupervisor(Supervisor supervisor, Counter counter){

		//removes the speed buff from the counter that the supervisor is leaving
		supervisor.slowDown(supervisor.getCurrentCounter());
		//removes the supervisor from the counter he/she is currently at
		supervisor.getCurrentCounter().setSupervisor(null);
		supervisor.getCurrentCounter().setHasSupervisor(false);

		//sets supervisor to be at the counter
		counter.setSupervisor(supervisor);
		//applies the supervisor speed buff to the new counter
		supervisor.speedUp(counter);
		//passes a reference of the new counter to the supervisor
		supervisor.setCurrentCounter(counter);
		counter.setHasSupervisor(true);
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

	public void addRegularCounter(){
		this.numberOfRegularCounters++;
	}

	public void addAutomaticCounter(){
		this.numberOfAutoCounters++;
	}

	public void addAgent(){
		this.numberOfAgents++;
	}

	public void addSupervisor(){
		this.numberOfSupervisors++;
	}

	public void addDiamond(){
		this.diamonds++;
	}

	public int getPoints() {
		return points;
	}

	public int getDiamonds() {
		return diamonds;
	}

	public int getNumberOfAgents() {
		return numberOfAgents;
	}

	public int getNumberOfRegularCounters() {
		return numberOfRegularCounters;
	}

	public int getNumberOfAutoCounters() {
		return numberOfAutoCounters;
	}

	public int getNumberOfSupervisors() {
		return numberOfSupervisors;
	}
}
