public class ReroutedPassenger extends AbstractPassenger {

	@Override
	public void processAt(Counter counter){
		if (counter.hasSupervisor){
			Player.getInstance().addPoints(REROUTED_POINTS);
		} else {
			//do absolutely nothing
		}
	}

}
