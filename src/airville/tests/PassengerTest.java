package airville.tests;

import airville.core.Player;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerType;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

/**
 * Created by nathaniel on 11/28/15.
 */
public class PassengerTest {

    Player player = Player.getInstance();

    @Before
    public void resetPoints(){
        player.resetCurrencies();
    }

    //Structured Branch in which passenger is regular
    @Test
    public void testProcessAtRegular() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.REGULAR);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.REGULAR.getPoints() == player.getPoints());
    }

    //Structured Branch in passenger has too many bags
    @Test
    public void testProcessAtExtraBaggage() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.EXTRABAGGAGE);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.EXTRABAGGAGE.getPoints() == player.getPoints());
    }

    //Structured Branch in which the plane is overbooked and the passenger
    //is getting a refund
    @Test
    public void testProcessAtOverbooked() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.OVERBOOKED);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.OVERBOOKED.getPoints() == player.getPoints());
    }

    //Structured Branch in which the passenger is rerouted
    //and needs help from a supervisor
    @Test
    public void testProcessAtRerouted() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.REROUTED);
        RegularCounter counter = new RegularCounter();
        counter.setSupervisor(Optional.of(new Supervisor()));
        passenger.processAt(counter);
        assertTrue(currentPoints + PassengerType.REROUTED.getPoints() == player.getPoints());
    }
}