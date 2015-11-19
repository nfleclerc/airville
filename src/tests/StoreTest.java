package tests;

import airville.Player;
import airville.Store;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class StoreTest {

    private Store store = new Store();

    @Before
    @After
    public void addMoneyForTesting(){
        Player.getInstance().resetCurrencies();
        Player.getInstance().addPoints(200);
        Player.getInstance().addDiamond();
    }

    @Test
    public void testBuyAgent() throws Exception {
        int currentNumberOfAgents = Player.getInstance().getNumberOfAgents();
        store.buyAgent();
        assertTrue(Player.getInstance().getNumberOfAgents() == currentNumberOfAgents + 1);
        assertEquals(200 - 20, Player.getInstance().getPoints());
    }

    @Test
    public void testBuySupervisor() throws Exception {
        int currentNumberOfSupervisors = Player.getInstance().getNumberOfSupervisors();
        store.buySupervisor();
        assertTrue(Player.getInstance().getNumberOfSupervisors() == currentNumberOfSupervisors + 1);
        assertEquals(0, Player.getInstance().getDiamonds());
    }

    @Test
    public void testBuyRegularCounter() throws Exception {
        int currentNumberOfRegCounters = Player.getInstance().getNumberOfRegularCounters();
        store.buyRegularCounter();
        assertTrue(Player.getInstance().getNumberOfRegularCounters() == currentNumberOfRegCounters + 1);
        assertEquals(200 - 100, Player.getInstance().getPoints());
    }

    @Test
    public void testBuyAutomaticCounter() throws Exception {
        int currentNumberOfAutoCounters = Player.getInstance().getNumberOfAutoCounters();
        store.buyAutomaticCounter();
        assertTrue(Player.getInstance().getNumberOfAutoCounters() == currentNumberOfAutoCounters + 1);
        assertEquals(200 - 50, Player.getInstance().getPoints());
    }
}