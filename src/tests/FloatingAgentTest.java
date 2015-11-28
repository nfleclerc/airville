package tests;

import airville.*;
import airville.gamepieces.Agent;
import airville.gamepieces.PurchasableGamePieceType;
import airville.gamepieces.counters.AutomaticCounter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class FloatingAgentTest {


    @Before
    public void clearLists(){
        Airport.getInstance().clearLists();
        Airport.getInstance().addItem(PurchasableGamePieceType.AGENT);
    }

    @Test
    public void testCallForAssistanceAt() throws Exception {
        Agent.callForAssistanceAt(new AutomaticCounter());
        assertTrue(Airport.getInstance().getAgents().isEmpty());
    }

    @Test
    public void testLeaveCounter() throws Exception {
        //gets the first agent
        Agent agent = Airport.getInstance().getAgents().get(0);
        //removes agent from the list
        //list is now empty
        Airport.getInstance().getAgents().remove(agent);
        //tells the agent to leave a counter and just go back to floating around
        //agent goes back in the list
        agent.leaveCounter(new AutomaticCounter());
        assertTrue(!Airport.getInstance().getAgents().isEmpty());
    }
}