package airville.tests;

import airville.core.Airport;
import airville.core.Player;
import airville.core.gamepieces.Agent;
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
 * A stress test for the whole code base.
 */
public class StressTest {

    private Airport airport = Airport.getInstance();
    private Player player = Player.getInstance();

    /**
     * Conducts the stress test on the whole code base. Queues 40000 groups to different counters.
     * Makes sure the resulting number of points is the correct amount.
     * @throws Exception
     */
    @Test
    public void stressTest() throws Exception{
        player.resetCurrencies();
        airport.clearLists();
        initializeGame();
        for (int i = 0; i < 10000; i++) {
            queuePassengers();
        }
        airport.getAutomaticCounters().forEach(Counter::processPassengers);
        airport.getRegularCounters().forEach(Counter::processPassengers);
        System.out.print(Player.getInstance().getPoints());
        assertTrue(44_000_000 == player.getPoints());
        assertAllAreNotBusy();
    }

    /**
     * Asserts that each game piece used is no longer busy and all queues
     * are empty i.e. all passengers have been processed.
     * @throws Exception
     */
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

    /**
     * Queues four groups of passengers consisting of certain amounts of
     * each type.
     */
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

    /**
     * Populates the airport with each type of game piece.
     */
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

    }

}
