package airville.tests;

import airville.core.Player;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.AbstractPassenger;
import airville.core.passengers.PassengerType;
import airville.core.passengers.RegularPassenger;
import org.junit.Test;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class RegularCounterTest {

    @Test
    public void testProcessPassengers() throws Exception {

        //Structured Branch:
        //test in which no passengers are frequent flyers
        int currentPoints = Player.getInstance().getPoints();
        RegularCounter counter = new RegularCounter();
        for (int i = 0; i < 5; i++) {
            AbstractPassenger.make(PassengerType.REGULAR, false).queueAt(counter);
        }
        assertEquals(counter.getPassengersInLine().size(), 5);
        counter.processPassengers();
        assertEquals(counter.getPassengersInLine().size(), 0);
        assertEquals(currentPoints + RegularPassenger.getPointValue() * 5,
                Player.getInstance().getPoints());

    }
}