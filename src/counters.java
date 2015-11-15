public class Counters {
	
	List<RegularCounters> regularCounters;
	List<AutomaticCounters> automaticCounters;

	public void addCounter(Counter counter){
		if (counter instanceof RegularCounter){
			regularCounters.add(counter);
		} else {
			automaticCounters.add(counter);
		}
	}

	public static RegularCounter getRegularCounter(){
		return (regularCounters.get(Math.random * regularCounters.size));
	}

}
