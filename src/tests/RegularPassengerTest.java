package tests;

import airville.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class RegularPassengerTest {

    @Test
    public void testProcessAt() throws Exception {
        RegularPassenger passenger = (RegularPassenger) AbstractPassenger.make(PassengerType.REGULAR, true);
        int pointsBeforeProcess = Player.getInstance().getPoints();
        passenger.processAt(new RegularCounter());
        int pointsAfterProcess = Player.getInstance().getPoints();
        assertEquals(pointsBeforeProcess + RegularPassenger.getPointValue(), pointsAfterProcess);
    }
}