
import java.util.function.Function;

public enum PassengerType {

	REGULAR(RegularPassenger::new),
	REROUTED(ReroutedPassenger::new),
	EXTRABAGGAGE(ExtraBaggagePassenger::new),
	OVERBOOKED(OverbookedPassenger::new);

	private Function<Boolean, Passenger> constructor;

	PassengerType(Function<Boolean, Passenger> constructor){
		this.constructor = constructor;
	}

	public Function getConstructor(){
		return this.constructor;
	}

}
