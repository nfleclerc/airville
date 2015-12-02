package airville.tests;

import airville.core.Airport;
import airville.core.Player;
import airville.core.Store;
import airville.core.gamepieces.GamePieceType;
import org.junit.Before;
import org.junit.Test;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class StoreTest {

    @Before
    public void addMoneyForTesting(){
        Player.getInstance().resetCurrencies();
        Player.getInstance().addPoints(200);
        Player.getInstance().addDiamond();
    }

    //Structured Branch in which an Automatic Counter is bought
    @Test
    public void testBuyAutomaticCounter() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        int playerCount = Player.getInstance().getNumberOfAutoCounters();
        int airportCount = Airport.getInstance().getAutomaticCounters().size();
        Store.getInstance().buyItem(GamePieceType.AUTO_COUNTER);
        assertTrue(currentPoints - GamePieceType.AUTO_COUNTER.getCost() == Player.getInstance().getPoints());
        assertTrue(playerCount + 1 == Player.getInstance().getNumberOfAutoCounters());
        assertTrue(airportCount + 1 == Airport.getInstance().getAutomaticCounters().size());
    }

    //Structured Branch in which a Regular Counter is bought
    @Test
    public void testBuyRegularCounter() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        int playerCount = Player.getInstance().getNumberOfRegularCounters();
        int airportCount = Airport.getInstance().getRegularCounters().size();
        Store.getInstance().buyItem(GamePieceType.REG_COUNTER);
        assertTrue(currentPoints - GamePieceType.REG_COUNTER.getCost() == Player.getInstance().getPoints());
        assertTrue(playerCount + 1 == Player.getInstance().getNumberOfRegularCounters());
        assertTrue(airportCount + 1 == Airport.getInstance().getRegularCounters().size());
    }

    //Structured Branch in which an Agent is bought
    @Test
    public void testBuyAgent() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        int playerCount = Player.getInstance().getNumberOfAgents();
        int airportCount = Airport.getInstance().getAgents().size();
        Store.getInstance().buyItem(GamePieceType.AGENT);
        assertTrue(currentPoints - GamePieceType.AGENT.getCost() == Player.getInstance().getPoints());
        assertTrue(playerCount + 1 == Player.getInstance().getNumberOfAgents());
        assertTrue(airportCount + 1 == Airport.getInstance().getAgents().size());
    }

    //Structured Branch in which a Supervisor is bought
    @Test
    public void testBuySupervisor() throws Exception {
        int diamonds = Player.getInstance().getDiamonds();
        int playerCount = Player.getInstance().getNumberOfSupervisors();
        int airportCount = Airport.getInstance().getSupervisors().size();
        Store.getInstance().buyItem(GamePieceType.SUPERVISOR);
        assertTrue(diamonds - GamePieceType.SUPERVISOR.getCost() == Player.getInstance().getDiamonds());
        assertTrue(playerCount + 1 == Player.getInstance().getNumberOfSupervisors());
        assertTrue(airportCount + 1 == Airport.getInstance().getSupervisors().size());
    }

}