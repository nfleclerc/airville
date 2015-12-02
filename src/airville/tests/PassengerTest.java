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
 * Tests the Passenger class.
 */
public class PassengerTest {

    Player player = Player.getInstance();

    /**
     * Resets the points in the Player class.
     */
    @Before
    public void resetPoints(){
        player.resetCurrencies();
    }

    /**
     * Tests the processAt() routine in Passenger in which the Passenger is Regular.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessAtRegular() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.REGULAR);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.REGULAR.getPoints() == player.getPoints());
    }

    /**
     * Tests the processAt() routine in Passenger in which the Passenger has Extra Baggage.
     * @throws Exception An exception indicating this test case has failed.
     */    @Test
    public void testProcessAtExtraBaggage() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.EXTRABAGGAGE);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.EXTRABAGGAGE.getPoints() == player.getPoints());
    }

    /**
     * Tests the processAt() routine in Passenger in which the Passenger is Overbooked.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testProcessAtOverbooked() throws Exception {
        int currentPoints = player.getPoints();
        Passenger passenger = new Passenger(false, PassengerType.OVERBOOKED);
        passenger.processAt(new RegularCounter());
        assertTrue(currentPoints + PassengerType.OVERBOOKED.getPoints() == player.getPoints());
    }

    /**
     * Tests the processAt() routine in Passenger in which the Passenger is Rerouted.
     * @throws Exception An exception indicating this test case has failed.
     */
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