public enum PassengerType {

	REGULAR(RegularPassenger::new);
	REROUTED(ReroutedPassenger::new);
	EXTRABAGGAGE(ExtraBaggagePassenger::new);
	OVERBOOKED(OverbookedPassenger::new);

	private Supplier constructor;

	private PassengerType(Supplier constructor){
		this.constructor = constructor;
	}

	public Supplier getConstructor(){
		return this.constructor;
	}

}
