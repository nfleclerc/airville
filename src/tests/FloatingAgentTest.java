package tests;

import airville.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class FloatingAgentTest {


    @Before
    public void clearLists(){
        GamePieces.clearLists();
        GamePieces.addFloatingAgent(new FloatingAgent());
    }

    @Test
    public void testCallForAssistanceAt() throws Exception {
        FloatingAgent.callForAssistanceAt(new AutomaticCounter());
        assertTrue(GamePieces.getFloatingAgents().isEmpty());
    }

    @Test
    public void testLeaveCounter() throws Exception {
        //gets the first agent
        FloatingAgent agent = GamePieces.getFloatingAgents().get(0);
        //removes agent from the list
        //list is now empty
        GamePieces.getFloatingAgents().remove(agent);
        //tells the agent to leave a counter and just go back to floating around
        //agent goes back in the list
        agent.leaveCounter(new AutomaticCounter());
        assertTrue(!GamePieces.getFloatingAgents().isEmpty());
    }
}