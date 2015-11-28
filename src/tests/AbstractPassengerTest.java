package tests;

import static org.junit.Assert.*;

import airville.gamepieces.counters.AutomaticCounter;
import airville.gamepieces.counters.Counter;
import airville.passengers.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class AbstractPassengerTest {

    @org.junit.Test
    public void testMake() throws Exception {
        assertTrue(AbstractPassenger.make(PassengerType.REGULAR, true) instanceof RegularPassenger);
        assertTrue(AbstractPassenger.make(PassengerType.REROUTED, true) instanceof ReroutedPassenger);
        assertTrue(AbstractPassenger.make(PassengerType.EXTRABAGGAGE, true) instanceof ExtraBaggagePassenger);
        assertTrue(AbstractPassenger.make(PassengerType.OVERBOOKED, true) instanceof OverbookedPassenger);
    }

    @org.junit.Test
    public void testQueueAt() throws Exception {
        RegularPassenger passenger = (RegularPassenger) AbstractPassenger.make(PassengerType.REGULAR, true);
        Counter counter = new AutomaticCounter();
        passenger.queueAt(counter);
        assertEquals(counter.getPassengersInLine().get(0), passenger);
    }
}