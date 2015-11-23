package tests;

import airville.Airport;
import airville.AutomaticCounter;
import airville.PurchasableGamePieceType;
import airville.RegularCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class AirportTest {

    @Before
    public void clearLists(){
        Airport.getInstance().clearLists();
    }

    @Test
    public void testAddCounter() throws Exception {

        //Structured Branch: Test if counter is automatic
        //makes sure counter is being added to the correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.AUTO_COUNTER);
        assertTrue(!Airport.getInstance().getAutomaticCounters().isEmpty());

        //Structured Branch: Test if counter is regular
        //sees if a counter is being added to the correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.REG_COUNTER);
        assertTrue(!Airport.getInstance().getRegularCounters().isEmpty());


    }
}