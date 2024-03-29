package airville.tests;

import airville.core.Airport;
import airville.core.Player;
import airville.core.gamepieces.Agent;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests the AutomaticCounter class.
 */
public class AutomaticCounterTest {


    /**
     * Resets the points in the Player class.
     */
    @Before
    public void resetPoints(){
        Player.getInstance().resetCurrencies();
    }

    /**
     * Tests the processPassenger() method with the case in which a passenger is
     * by themself and Regular.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessRegularPassengers() throws Exception {

        //Structured Branch:
        //test in which all passengers are Regular and are not in a group
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(new Agent());
        AutomaticCounter counter = new AutomaticCounter();
        List<Passenger> passengerList = new LinkedList<>();

        passengerList.add(new Passenger(false, PassengerType.REGULAR));
        PassengerGroup group = new PassengerGroup(passengerList);
        group.queueAt(counter);
        assertEquals(1, counter.getLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        assertEquals(currentPoints + PassengerType.REGULAR.getPoints() * 1,
                Player.getInstance().getPoints());

    }

    /**
     * Tests the processPassenger() method with the case in which a passenger is
     * by themself but is not Regular.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessNonRegularPassengers() throws Exception {
        //Structured Branch:
        //test in which passengers are not Regular and not in group
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(new RegularCounter());
        AutomaticCounter counter = new AutomaticCounter();
        List<Passenger> passengerList = new LinkedList<>();

        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));

        PassengerGroup group = new PassengerGroup(passengerList);
        group.queueAt(counter);
        assertEquals(1, counter.getLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        //no points should be added since they should have all been queued at another counter
        //instead of being processed
        assertEquals(currentPoints,
                Player.getInstance().getPoints());

    }

    /**
     * Tests the processPassenger() method with the case in which a passenger is not
     * by themself and Regular.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessPassengersInGroups() throws Exception{
        //Structured Branch:
        //test in which passengers are in a group but they
        //are all regular
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(new RegularCounter());
        Airport.getInstance().addItem(new Agent());
        List<Passenger> passengerList = new LinkedList<>();

        //set up the passenger group
        for (int i = 0; i < 3; i++) {
            passengerList.add(new Passenger(false, PassengerType.REGULAR));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();
        group.queueAt(counter);

        assertEquals(1, counter.getLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        //these passengers should all be processed normally so points
        //should be awarded
        assertEquals(currentPoints + PassengerType.REGULAR.getPoints() * 3,
                Player.getInstance().getPoints());

    }

    /**
     * Tests the processPassenger() method with the case in which a passenger is not
     * by themself and one in the group is not Regular.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessPassengersInGroupsWithASpecialPassenger() throws Exception{
        //Structured Branch:
        //test in which passengers are in a group but one
        //member is not regular
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(new RegularCounter());
        Airport.getInstance().addItem(new Agent());
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            passengerList.add(new Passenger(false, PassengerType.REGULAR));
        }
        //add the non regular passenger to the list
        passengerList.add(new Passenger(false, PassengerType.OVERBOOKED));
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();

        group.queueAt(counter);
        assertEquals(1, counter.getLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        //these passengers should all be requeued at another line so no
        //points should be awarded yet
        assertEquals(currentPoints,
                Player.getInstance().getPoints());

    }
}