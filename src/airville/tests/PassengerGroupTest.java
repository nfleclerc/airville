package airville.tests;

import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;
import org.junit.Test;
import static org.junit.Assert.*;

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
            passengerList.add(new Passenger(false, PassengerType.REGULAR));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();
        group.queueAt(counter);
        //testing if all passengers are queued at the same counter
        assertTrue(4 == counter.getLine().peek().size());
    }

    @Test
    public void testIsOfRegularPassengers() throws Exception {
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            passengerList.add(new Passenger(false, PassengerType.REGULAR));
        }

        //Structured Branch in which not all passengers are regular
        //Also Edge Case in which only passenger is not regular and
        //it is also the last passenger in the group
        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));
        PassengerGroup group = new PassengerGroup(passengerList);
        assertFalse(group.isOfRegularPassengers());

        //Structured Branch in which all passengers are regular
        passengerList.remove(passengerList.size() - 1);
        group = new PassengerGroup(passengerList);
        assertTrue(group.isOfRegularPassengers());
    }

    @Test
    public void testIsOnePassenger() throws Exception {

        List<Passenger> passengerList = new LinkedList<>();
        passengerList.add(new Passenger(false, PassengerType.REGULAR));

        //Structured Branch in which group is only one passenger
        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));
        PassengerGroup group = new PassengerGroup(passengerList);
        assertTrue(group.isOnePassenger());

        //Structured Branch in which there are multiple
        //passengers
        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));
        group = new PassengerGroup(passengerList);
        assertFalse(group.isOnePassenger());    }

    @Test
    public void testProcessAt() throws Exception {

    }
}