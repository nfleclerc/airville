public class ReroutedPassenger extends AbstractPassenger {

	ReroutedPassenger(boolean frequentFlyer){
		super(frequentFlyer);
	}

	@Override
	public void processAt(Counter counter){
		if (counter.hasSupervisor()){
			//if the counter has a supervisor the passenger
			//can be processed as normal
			addPointsToPlayer();
		} else {
			//if there is no supervisor
			while (!counter.hasSupervisor()){
				//do absolutely nothing
				//just keep stalling until the supervisor is at the counter
			}
			//after the supervisor comes add points to player
			addPointsToPlayer();
		}
	}

	private void addPointsToPlayer(){
		Player.getInstance().addPoints(REROUTED_POINTS);
	}

}
