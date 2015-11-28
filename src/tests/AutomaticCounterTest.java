package tests;

import airville.*;
import airville.gamepieces.PurchasableGamePieceType;
import airville.gamepieces.counters.AutomaticCounter;
import airville.passengers.*;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class AutomaticCounterTest {

    @Test
    public void testProcessRegularPassengers() throws Exception {

        //Structured Branch:
        //test in which all passengers are Regular and are not in a group
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
        AutomaticCounter counter = new AutomaticCounter();
        for (int i = 0; i < 5; i++) {
            AbstractPassenger.make(PassengerType.REGULAR, false).queueAt(counter);
        }
        assertEquals(5, counter.getPassengersInLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getPassengersInLine().size());
        assertEquals(currentPoints + RegularPassenger.getPointValue() * 5,
                Player.getInstance().getPoints());

    }

    @Test
    public void testProcessNonRegularPassengers() throws Exception {
        //Structured Branch:
        //test in which passengers are not Regular and not in group
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(PurchasableGamePieceType.REG_COUNTER);
        AutomaticCounter counter = new AutomaticCounter();
        for (int i = 0; i < 3; i++) {
            AbstractPassenger.make(PassengerType.EXTRABAGGAGE, false).queueAt(counter);
        }
        assertEquals(3, counter.getPassengersInLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getPassengersInLine().size());
        //no points should be added since they should have all been queued at another counter
        //instead of being processed
        assertEquals(currentPoints,
                Player.getInstance().getPoints());

    }

    @Test
    public void testProcessPassengersInGroups(){
        //Structured Branch:
        //test in which passengers are in a group but they
        //are all regular
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(PurchasableGamePieceType.REG_COUNTER);
        Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
        List<Passenger> passengerList = new LinkedList<>();

        //set up the passenger group
        for (int i = 0; i < 3; i++) {
            passengerList.add(AbstractPassenger.make(PassengerType.REGULAR, false));
        }
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();
        group.queueAt(counter);

        assertEquals(3, counter.getPassengersInLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getPassengersInLine().size());
        //these passengers should all be processed normally so points
        //should be awarded
        assertEquals(currentPoints + RegularPassenger.getPointValue() * 3,
                Player.getInstance().getPoints());

    }

    @Test
    public void testProcessPassengersInGroupsWithASpecialPassenger(){
        //Structured Branch:
        //test in which passengers are in a group but one
        //member is not regular
        int currentPoints = Player.getInstance().getPoints();
        Airport.getInstance().addItem(PurchasableGamePieceType.REG_COUNTER);
        Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
        List<Passenger> passengerList = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            passengerList.add(AbstractPassenger.make(PassengerType.REGULAR, false));
        }
        //add the non regular passenger to the list
        passengerList.add(AbstractPassenger.make(PassengerType.EXTRABAGGAGE, false));
        PassengerGroup group = new PassengerGroup(passengerList);
        AutomaticCounter counter = new AutomaticCounter();

        group.queueAt(counter);
        assertEquals(4, counter.getPassengersInLine().size());
        counter.processPassengers();
        assertEquals(0, counter.getPassengersInLine().size());
        //these passengers should all be requeued at another line so no
        //points should be awarded yet
        assertEquals(currentPoints,
                Player.getInstance().getPoints());

    }
}