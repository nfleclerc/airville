package airville.tests;

import airville.core.Player;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import airville.core.passengers.PassengerType;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class RegularCounterTest {

    @Test
    public void testProcessPassengers() throws Exception {

        //Structured Branch:
        //test in which no passengers are frequent flyers
        int currentPoints = Player.getInstance().getPoints();
        RegularCounter counter = new RegularCounter();
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            passengerList.add(new Passenger(false, PassengerType.REGULAR));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        group.queueAt(counter);
        assertEquals(1, counter.getLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        assertEquals(currentPoints + PassengerType.REGULAR.getPoints() * 3,
                Player.getInstance().getPoints());

    }

    @Test
    public void testProcessFrequentFlyers() throws Exception {

        //Structured Branch:
        //test in which passengers are frequent flyers
        int currentPoints = Player.getInstance().getPoints();
        RegularCounter counter = new RegularCounter();
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            passengerList.add(new Passenger(true, PassengerType.REGULAR));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        group.queueAt(counter);
        assertEquals(3, counter.getLine().peek().size());
        counter.processPassengers();
        assertEquals(0, counter.getLine().size());
        assertEquals(currentPoints + PassengerType.REGULAR.getPoints() * 3,
                Player.getInstance().getPoints());

    }
}