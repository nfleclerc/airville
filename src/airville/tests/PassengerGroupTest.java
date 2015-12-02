package airville.tests;

import airville.core.Player;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

/**
 * Tests the PassengerGroup class.
 */
public class PassengerGroupTest {

    /**
     * Test the queueAt() routine in PassengerGroup.
     * @throws Exception
     */
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

    /**
     * Test the isOfRegularPassengers() routine in PassengerGroup.
     * @throws Exception
     */
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

    /**
     * Tests the isOnePassenger() routine in PassengerGroup.
     * @throws Exception
     */
    @Test
    public void testIsOnePassenger() throws Exception {

        List<Passenger> passengerList = new LinkedList<>();
        passengerList.add(new Passenger(false, PassengerType.REGULAR));

        //Structured Branch in which group is only one passenger
        PassengerGroup group = new PassengerGroup(passengerList);
        assertTrue(group.isOnePassenger());

        //Structured Branch in which there are multiple
        //passengers
        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));
        group = new PassengerGroup(passengerList);
        assertFalse(group.isOnePassenger());
    }

    /**
     * Tests the processAt() routine in PassengerGroup.
     * @throws Exception
     */
    @Test
    public void testProcessAt() throws Exception {

        int currentPoints = Player.getInstance().getPoints();
        List<Passenger> passengers = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            passengers.add(new Passenger(false, PassengerType.REGULAR));
        }
        PassengerGroup group = new PassengerGroup(passengers);
        group.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.REGULAR.getPoints() * 5
                == Player.getInstance().getPoints());

    }

    /**
     * Tests the isOfFrequentFlyers() routine in PassengerGroup.
     * @throws Exception
     */
    @Test
    public void testIsOfFrequentFlyers() throws Exception {
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            passengerList.add(new Passenger(true, PassengerType.REGULAR));
        }

        //Structured Branch in which not all passengers are freq flyers
        //Also Edge Case in which only passenger is not a freq flyer and
        //it is also the last passenger in the group
        passengerList.add(new Passenger(false, PassengerType.REGULAR));
        PassengerGroup group = new PassengerGroup(passengerList);
        assertFalse(group.isOfFrequentFlyers());

        //Structured Branch in which all passengers are regular
        passengerList.remove(passengerList.size() - 1);
        group = new PassengerGroup(passengerList);
        assertTrue(group.isOfFrequentFlyers());

    }
}