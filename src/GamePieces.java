import java.util.ArrayList;
import java.util.List;

public class GamePieces {
	
	private static List<RegularCounter> regularCounters = new ArrayList<>();
	private static List<AutomaticCounter> automaticCounters = new ArrayList<>();
	private static List<FloatingAgent> floatingAgents = new ArrayList<>();
	private static List<Supervisor> supervisors = new ArrayList<>();

	public static void addCounter(Counter counter){
		if (counter instanceof RegularCounter){
			regularCounters.add((RegularCounter)counter);
		} else {
			automaticCounters.add((AutomaticCounter)counter);
		}
	}

	public static void addFloatingAgent(FloatingAgent agent){
		floatingAgents.add(agent);
	}

	public static void addSupervisor(Supervisor supervisor){
		supervisors.add(supervisor);
	}

	public static RegularCounter getRegularCounter(){
		return (regularCounters.get((int) (Math.random() * regularCounters.size())));
	}

	public static List<RegularCounter> getRegularCounters() {
		return regularCounters;
	}

	public static List<AutomaticCounter> getAutomaticCounters() {
		return automaticCounters;
	}

	public static List<FloatingAgent> getFloatingAgents() {
		return floatingAgents;
	}

	public static List<Supervisor> getSupervisors() {
		return supervisors;
	}
}
