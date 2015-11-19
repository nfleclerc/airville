package tests;

import airville.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class ReroutedPassengerTest {

    @Test
    public void testProcessAt() throws Exception {
        ReroutedPassenger passenger = (ReroutedPassenger) AbstractPassenger.make(PassengerType.REROUTED, true);
        int pointsBeforeProcess = Player.getInstance().getPoints();
        RegularCounter counter = new RegularCounter();
        //Structured Branch Testing
        //branch where there is a supervisor at this counter
        counter.setSupervisor(new Supervisor());
        counter.setHasSupervisor(true);
        passenger.processAt(counter);
        int pointsAfterProcess = Player.getInstance().getPoints();
        assertEquals(pointsBeforeProcess + ReroutedPassenger.getPointValue(), pointsAfterProcess);

        //not testing the branch where there is no supervisor as that would just result in an
        //an infinite loop. that branch will only work when the real-time team
        //drops some scheduling code into the program so that multiple actions can occur
        //concurrently ie this branch requires the user to move the supervisor over here
        //while this loop is executing
    }
}