package tests;

import airville.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class OverbookedPassengerTest {

    @Test
    public void testProcessAt() throws Exception {
        OverbookedPassenger passenger = (OverbookedPassenger) AbstractPassenger.make(PassengerType.OVERBOOKED, true);
        int pointsBeforeProcess = Player.getInstance().getPoints();
        passenger.processAt(new RegularCounter());
        int pointsAfterProcess = Player.getInstance().getPoints();
        assertEquals(pointsBeforeProcess + OverbookedPassenger.getPointValue(), pointsAfterProcess);
    }
}