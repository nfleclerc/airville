import java.util.List;

public class GamePieces {
	
	static List<RegularCounter> regularCounters;
	static List<AutomaticCounter> automaticCounters;

	public static void addCounter(Counter counter){
		if (counter instanceof RegularCounter){
			regularCounters.add((RegularCounter)counter);
		} else {
			automaticCounters.add((AutomaticCounter)counter);
		}
	}

	public static RegularCounter getRegularCounter(){
		return (regularCounters.get((int) (Math.random() * regularCounters.size())));
	}

}
