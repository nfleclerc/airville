package tests;

import airville.*;
import airville.gamepieces.counters.RegularCounter;
import airville.passengers.AbstractPassenger;
import airville.passengers.PassengerType;
import airville.passengers.RegularPassenger;
import org.junit.Test;

import static org.junit.Assert.*;

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