package tests;

import airville.AutomaticCounter;
import airville.GamePieces;
import airville.RegularCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class GamePiecesTest {

    @Before
    public void clearLists(){
        GamePieces.clearLists();
    }

    @Test
    public void testAddCounter() throws Exception {

        //Structured Branch: Test if counter is automatic
        //makes sure counter is being added to the correct list
        GamePieces.addCounter(new AutomaticCounter());
        assertTrue(!GamePieces.getAutomaticCounters().isEmpty());

        //Structured Branch: Test if counter is regular
        //sees if a counter is being added to the correct list
        GamePieces.addCounter(new RegularCounter());
        assertTrue(!GamePieces.getRegularCounters().isEmpty());


    }
}