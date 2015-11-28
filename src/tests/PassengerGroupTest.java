package tests;

import airville.gamepieces.counters.AutomaticCounter;
import airville.passengers.AbstractPassenger;
import airville.passengers.Passenger;
import airville.passengers.PassengerGroup;
import airville.passengers.PassengerType;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class PassengerGroupTest {

    @Test
    public void testQueueAt() throws Exception {
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            passengerList.add(AbstractPassenger.make(PassengerType.REGULAR, false));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();
        group.queueAt(counter);
        //testing if all passengers are queued at the same counter
        assertEquals(4, counter.getPassengersInLine().size());
    }
}