package airville.tests;

import airville.core.Airport;
import airville.core.gamepieces.Agent;
import airville.core.gamepieces.Supervisor;
import airville.core.gamepieces.counters.AutomaticCounter;
import airville.core.gamepieces.counters.RegularCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class AirportTest {

    /**
     * Clear the lists of the Airport class.
     */
    @Before
    public void clearLists(){
        Airport.getInstance().clearLists();
    }

    /**
     * Tests the addItem() routine of Airport. Tests adding an Automatic Counter,
     * Regular Counter, Supervisor, and Agent
     * @throws Exception
     */
    @Test
    public void testAddItem() throws Exception {

        //Structured Branch: Test if counter is automatic
        //makes sure counter is being added to the correct list
        Airport.getInstance().addItem(new AutomaticCounter());
        assertTrue(!Airport.getInstance().getAutomaticCounters().isEmpty());

        //Structured Branch: Test if counter is regular
        //sees if a counter is being added to the correct list
        Airport.getInstance().addItem(new RegularCounter());
        assertTrue(!Airport.getInstance().getRegularCounters().isEmpty());

        //Structured Branch: Test if supervisor is being added to correct list
        Airport.getInstance().addItem(new Supervisor());
        assertTrue(!Airport.getInstance().getSupervisors().isEmpty());

        //Structured Branch: Test is agent is being added to correct list
        Airport.getInstance().addItem(new Agent());
        assertTrue(!Airport.getInstance().getAgents().isEmpty());


    }

}