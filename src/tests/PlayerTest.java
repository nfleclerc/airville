package tests;

import airville.Player;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class PlayerTest {


    @Before
    @After
    public void resetCurrencies(){
        Player.getInstance().resetCurrencies();
    }

    @Test
    public void testMoveSupervisor() throws Exception {

    }

    @Test
    public void testAddPoints() throws Exception {
        int currentPoints = Player.getInstance().getPoints();
        Player.getInstance().addPoints(17);
        assertTrue(currentPoints + 17 == Player.getInstance().getPoints());
    }

    @Test
    public void testRemovePoints() throws Exception {
        int currentPoints = Player.getInstance().getPoints() + 50;
        Player.getInstance().removePoints(17);
        assertTrue(currentPoints - 17 == Player.getInstance().getPoints() + 50);
    }

    @Test
    public void testRemoveDiamonds() throws Exception {
        int currentDiamonds = Player.getInstance().getDiamonds() + 50;
        Player.getInstance().removeDiamonds(19);
        assertTrue(currentDiamonds - 19 == Player.getInstance().getDiamonds() + 50);
    }

    @Test
    public void testAddRegularCounter() throws Exception {
        int currentRegCounters = Player.getInstance().getNumberOfRegularCounters();
        Player.getInstance().addRegularCounter();
        assertTrue(currentRegCounters + 1 ==
                Player.getInstance().getNumberOfRegularCounters());
    }

    @Test
    public void testAddAutomaticCounter() throws Exception {
        int currentAutoCounters = Player.getInstance().getNumberOfAutoCounters();
        Player.getInstance().addAutomaticCounter();
        assertTrue(currentAutoCounters + 1 ==
                Player.getInstance().getNumberOfAutoCounters());
    }

    @Test
    public void testAddAgent() throws Exception {
        int currentAgentCount = Player.getInstance().getNumberOfAgents();
        Player.getInstance().addAgent();
        assertTrue(currentAgentCount + 1 ==
                Player.getInstance().getNumberOfAgents());
    }

    @Test
    public void testAddSupervisor() throws Exception {
        int currentSupervisorCount = Player.getInstance().getNumberOfSupervisors();
        Player.getInstance().addSupervisor();
        assertTrue(currentSupervisorCount + 1 ==
                Player.getInstance().getNumberOfSupervisors());
    }

    @Test
    public void testAddDiamond() throws Exception {
        int currentDiamonds = Player.getInstance().getDiamonds();
        Player.getInstance().addDiamond();
        assertTrue(currentDiamonds + 1 == Player.getInstance().getDiamonds());
    }
}