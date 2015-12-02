package airville.tests;

import airville.core.Player;
import airville.core.gamepieces.GamePieceType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Player class.
 */
public class PlayerTest {


    /**
     * Rests the points in the Player class.
     */
    @Before
    @After
    public void resetCurrencies(){
        Player.getInstance().resetCurrencies();
    }

    /**
     * Tests adding points to the Player.
     * @throws Exception
     */
    @Test
    public void testAddPoints() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        Player.getInstance().addPoints(17);
        assertTrue(currentPoints + 17 == Player.getInstance().getPoints());
    }

    /**
     * Tests removing points from the Player.
     * @throws Exception
     */
    @Test
    public void testRemovePoints() throws Exception {
        int currentPoints = Player.getInstance().getPoints() + 50;
        Player.getInstance().removePoints(17);
        assertTrue(currentPoints - 17 == Player.getInstance().getPoints() + 50);
    }

    /**
     * Tests removing diamonds from the Player.
     * @throws Exception
     */
    @Test
    public void testRemoveDiamonds() throws Exception {
        int currentDiamonds = Player.getInstance().getDiamonds() + 50;
        Player.getInstance().removeDiamonds(19);
        assertTrue(currentDiamonds - 19 == Player.getInstance().getDiamonds() + 50);
    }

    /**
     * Tests the increaseCountOf() routine in Player in which a RegularCounter is being added.
     * @throws Exception
     */
    @Test
    public void testAddRegularCounter() throws Exception {
        int currentRegCounters = Player.getInstance().getNumberOfRegularCounters();
        Player.getInstance().increaseCountOf(GamePieceType.REG_COUNTER);
        assertTrue(currentRegCounters + 1 ==
                Player.getInstance().getNumberOfRegularCounters());
    }

    /**
     * Tests the increaseCountOf() routine in Player in which an AutomaticCounter is being added.
     * @throws Exception
     */
    @Test
    public void testAddAutomaticCounter() throws Exception {
        int currentAutoCounters = Player.getInstance().getNumberOfAutoCounters();
        Player.getInstance().increaseCountOf(GamePieceType.AUTO_COUNTER);
        assertTrue(currentAutoCounters + 1 ==
                Player.getInstance().getNumberOfAutoCounters());
    }

    /**
     * Tests the increaseCountOf() routine in Player in which an Agent is being added.
     * @throws Exception
     */
    @Test
    public void testAddAgent() throws Exception {
        int currentAgentCount = Player.getInstance().getNumberOfAgents();
        Player.getInstance().increaseCountOf(GamePieceType.AGENT);
        assertTrue(currentAgentCount + 1 ==
                Player.getInstance().getNumberOfAgents());
    }

    /**
     * Tests the increaseCountOf() routine in Player in which a Supervisor is being added.
     * @throws Exception
     */
    @Test
    public void testAddSupervisor() throws Exception {
        int currentSupervisorCount = Player.getInstance().getNumberOfSupervisors();
        Player.getInstance().increaseCountOf(GamePieceType.SUPERVISOR);
        assertTrue(currentSupervisorCount + 1 ==
                Player.getInstance().getNumberOfSupervisors());
    }

    /**
     * Tests the increaseCountOf() routine in Player in which a regular counter is being added.
     * @throws Exception
     */
    @Test
    public void testAddDiamond() throws Exception {
        int currentDiamonds = Player.getInstance().getDiamonds();
        Player.getInstance().addDiamond();
        assertTrue(currentDiamonds + 1 == Player.getInstance().getDiamonds());
    }

    /**
     * Tests the resetCurrencies() routine in Player.
     */
    @Test
    public void testResetCurrencies(){
        Player.getInstance().resetCurrencies();
        assertTrue(0 == Player.getInstance().getPoints());
        assertTrue(0 == Player.getInstance().getDiamonds());
    }

}