package airville.tests;

import airville.core.Player;
import airville.core.Store;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class StoreTest {

    private Store store = Store.getInstance();

    @Before
    @After
    public void addMoneyForTesting(){
        Player.getInstance().resetCurrencies();
        Player.getInstance().addPoints(200);
        Player.getInstance().addDiamond();
    }

    @Test
    public void testBuyItem() throws Exception {

    }

}