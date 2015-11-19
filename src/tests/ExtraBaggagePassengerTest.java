package tests;

import airville.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class ExtraBaggagePassengerTest {

    @Test
    public void testProcessAt() throws Exception {
        ExtraBaggagePassenger passenger = (ExtraBaggagePassenger) AbstractPassenger.make(PassengerType.EXTRABAGGAGE, true);
        int pointsBeforeProcess = Player.getInstance().getPoints();
        passenger.processAt(new RegularCounter());
        int pointsAfterProcess = Player.getInstance().getPoints();
        assertEquals(pointsBeforeProcess + ExtraBaggagePassenger.getPointValue(), pointsAfterProcess);
    }
}