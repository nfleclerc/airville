public class AutomaticCounter extends Counter {

	@Override
	public void processPassengers() {
		for (Passenger passenger : passengersInLine){
			if (passenger instanceof RegularPassenger){
				processPassengersInGroups(passenger);
			} else {
				passengersInLine.remove(passenger);
				passenger.queueAt(Counters.getRegularCounter);
			}
		}
	}

	private void processPassengersInGroups(Passenger passenger){
		if (!passenger.isInGroup()){
			processPassenger(passenger);
		} else {
			if (!checkGroupForSpecialPassengers(passenger.getGroup()){
				processPassenger(passenger);
			} else {
				passengersInLine.remove(passenger);
				passenger.getGroup().queueAt(Counters.getRegularCounter);
			}
		}
	}

	private void checkGroupForSpecialPassengers(PassengerGroup group){
		for (Passsenger passenger : goup.getPassengers()){
			if (!passenger instanceof RegularPassenger){
				return true;
			}
		}
		return false;
	}

	private void processPassenger(Passenger passenger){
		if (Math.random() > 0.5){
			passenger.processAt(this);
			passengersInLine.remove(passenger);
		} else {
			FloatingAgent agent = FloatingAgent.callForAssistanceAt(this);
			passenger.processAt(this);
			passengersInline.remove(passenger);
			agent.leaveCounter();
		}
	}

}
