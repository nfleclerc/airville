package tests;

import airville.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class AutomaticCounterTest {

    @Test
    public void testProcessPassengers() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        GamePieces.addFloatingAgent(new FloatingAgent());
        AutomaticCounter counter = new AutomaticCounter();
        for (int i = 0; i < 5; i++) {
            AbstractPassenger.make(PassengerType.REGULAR, false).queueAt(counter);
        }

        assertEquals(5, counter.getPassengersInLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getPassengersInLine().size());
        assertEquals(currentPoints + RegularPassenger.getPointValue() * 5,
                Player.getInstance().getPoints());

    }
}