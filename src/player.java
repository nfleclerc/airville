public class Player {
	
	private int points;
	private int diamonds;
	private int numberOfAgents;
	private int numberOfRegularCounters;
	private int numberOfAutoCounters;
	private int numberOfSupervisors;
	private static final Player instance = new Player();

	private Player(){
	}

	public static Player getInstance(){
		return instance;
	}	

	public void moveSupervisor(Supervisor supervisor){
	}

	public void addPoints(int points){
		this.points += points;
	}


}
