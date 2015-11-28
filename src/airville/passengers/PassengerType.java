package airville.passengers;

import java.util.function.Function;

public enum PassengerType {

	REGULAR(1, 1),
	REROUTED(1, 10),
	EXTRABAGGAGE(2, 5),
	OVERBOOKED(1.5, 5);

	private double busyTime;
	private int points;

	PassengerType(double busyTime, int points){
		this.busyTime = busyTime;
		this.points = points;
	}

	public double getBusyTime(){
		return this.busyTime;
	}

	public int getPoints(){
		return this.points;
	}

}
