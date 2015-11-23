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

}