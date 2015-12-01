package airville.tests;

import airville.core.Airport;
import airville.core.gamepieces.PurchasableGamePieceType;
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
    public void testAddItem() throws Exception {

        //Structured Branch: Test if counter is automatic
        //makes sure counter is being added to the correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.AUTO_COUNTER);
        assertTrue(!Airport.getInstance().getAutomaticCounters().isEmpty());

        //Structured Branch: Test if counter is regular
        //sees if a counter is being added to the correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.REG_COUNTER);
        assertTrue(!Airport.getInstance().getRegularCounters().isEmpty());

        //Structured Branch: Test if supervisor is being added to correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.SUPERVISOR);
        assertTrue(!Airport.getInstance().getSupervisors().isEmpty());

        //Structured Branch: Test is agent is being added to correct list
        Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
        assertTrue(!Airport.getInstance().getAgents().isEmpty());


    }

}