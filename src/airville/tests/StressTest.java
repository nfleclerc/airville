package airville.tests;

import airville.core.Airport;
import airville.core.Player;
import airville.core.Store;
import airville.core.gamepieces.Agent;
import airville.core.gamepieces.GamePieceType;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.Counter;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by nathaniel on 12/1/15.
 */
public class StressTest {

    private Airport airport = Airport.getInstance();
    private Player player = Player.getInstance();

    @Test
    public void stressTest() throws Exception{
        initializeGame();
        for (int i = 0; i < 10000; i++) {
            queuePassengers();
        }
        airport.getAutomaticCounters().forEach(Counter::processPassengers);
        airport.getRegularCounters().forEach(Counter::processPassengers);
        assertTrue(44_000_000 == player.getPoints());
        assertAllAreNotBusy();
    }

    private void assertAllAreNotBusy() throws Exception{
        for (Counter counter : airport.getAutomaticCounters()){
            assertFalse(counter.isBusy());
            assertTrue(counter.getLine().isEmpty());
        }
        for (Counter counter : airport.getRegularCounters()){
            assertFalse(counter.isBusy());
            assertTrue(counter.getLine().isEmpty());
        }
        for (Agent agent : airport.getAgents()){
            assertFalse(agent.isBusy());
        }
    }

    private void queuePassengers(){
        List<Passenger> passengers = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            passengers.add(new Passenger(true, PassengerType.REGULAR));
        }
        new PassengerGroup(passengers).queueAt(airport.getRandomAutomaticCounter());
        for (int i = 0; i < 100; i++) {
            passengers.add(new Passenger(false, PassengerType.OVERBOOKED));
        }
        new PassengerGroup(passengers).queueAt(airport.getRandomRegularCounter());
        for (int i = 0; i < 100; i++) {
            passengers.add(new Passenger(true, PassengerType.REROUTED));
        }
        new PassengerGroup(passengers).queueAt(airport.getRandomAutomaticCounter());
        for (int i = 0; i < 100; i++) {
            passengers.add(new Passenger(false, PassengerType.EXTRABAGGAGE));
        }
        new PassengerGroup(passengers).queueAt(airport.getRandomRegularCounter());
    }

    private void initializeGame(){

        for (int i = 0; i < player.getNumberOfAutoCounters(); i++) {
            airport.addItem(new AutomaticCounter());
        }

        for (int i = 0; i < player.getNumberOfRegularCounters(); i++) {
            airport.addItem(new RegularCounter());
        }

        for (int i = 0; i < player.getNumberOfAgents(); i++) {
            airport.addItem(new Agent());
        }

        for (int i = 0; i < player.getNumberOfSupervisors(); i++) {
            airport.addItem(new Supervisor());
        }

    }

}
