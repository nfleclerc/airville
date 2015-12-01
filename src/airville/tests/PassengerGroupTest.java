package airville.tests;

import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.passengers.AbstractPassenger;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

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
        assertEquals(4, counter.getLine().size());
    }

    @Test
    public void testIsOfRegularPassengers() throws Exception {

    }

    @Test
    public void testIsOnePassenger() throws Exception {

    }

    @Test
    public void testProcessAt() throws Exception {

    }
}