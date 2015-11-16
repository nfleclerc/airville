public class AutomaticCounter extends Counter {

	@Override
	public void processPassengers() {
		for (Passenger passenger : getPassengersInLine()){
			if (passenger instanceof RegularPassenger){
				processPassengersInGroups(passenger);
			} else {
				getPassengersInLine().remove(passenger);
				passenger.queueAt(Counters.getRegularCounter());
			}
		}
	}

	private void processPassengersInGroups(Passenger passenger){
		if (!passenger.isInGroup()){
			processPassenger(passenger);
		} else {
			if (!checkGroupForSpecialPassengers(passenger.getGroup())){
				processPassenger(passenger);
			} else {
				getPassengersInLine().remove(passenger);
				passenger.getGroup().queueAt(Counters.getRegularCounter());
			}
		}
	}

	private boolean checkGroupForSpecialPassengers(PassengerGroup group){
		for (Passenger passenger : group.getPassengers()){
			if ((passenger instanceof RegularPassenger)){
				return true;
			}
		}
		return false;
	}

	private void processPassenger(Passenger passenger){
		if (Math.random() > 0.5){
			passenger.processAt(this);
			getPassengersInLine().remove(passenger);
		} else {
			FloatingAgent agent = FloatingAgent.callForAssistanceAt(this);
			passenger.processAt(this);
			getPassengersInLine().remove(passenger);
			agent.leaveCounter();
		}
	}

}
