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
        store.buyAgent();
        assertTrue(Player.getInstance().getNumberOfAgents() == 3);
        assertEquals(200 - 20, Player.getInstance().getPoints());
    }

    @Test
    public void testBuySupervisor() throws Exception {
        store.buySupervisor();
        assertTrue(Player.getInstance().getNumberOfSupervisors() == 2);
        assertEquals(0, Player.getInstance().getDiamonds());
    }

    @Test
    public void testBuyRegularCounter() throws Exception {
        store.buyRegularCounter();
        assertTrue(Player.getInstance().getNumberOfRegularCounters() == 5);
        assertEquals(200 - 100, Player.getInstance().getPoints());
    }

    @Test
    public void testBuyAutomaticCounter() throws Exception {
        store.buyAutomaticCounter();
        assertTrue(Player.getInstance().getNumberOfAutoCounters() == 5);
        assertEquals(200 - 50, Player.getInstance().getPoints());
    }
}