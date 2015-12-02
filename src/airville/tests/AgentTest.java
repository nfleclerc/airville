package airville.tests;

import airville.core.Airport;
import airville.core.gamepieces.Agent;
import airville.core.passengers.Passenger;
import airville.core.passengers.PassengerGroup;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Tests the Agent class.
 */
public class AgentTest {


    /**
     * Clears all the lists in the Airport class.
     */
    @Before
    public void clearLists(){
        Airport.getInstance().clearLists();
        Airport.getInstance().addItem(new Agent());
    }

    /**
     * Tests the callForAssistance() routine of Agent.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testCallForAssistanceAt() throws Exception {
        List<Passenger> passengers = new LinkedList<>();
        Agent.callForAssistance(new PassengerGroup(passengers));
        assertTrue(Airport.getInstance().getAgents().isEmpty());
    }

    /**
     * Tests the leaveCounter() routine of Agent.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testLeaveCounter() throws Exception {
        //gets the first agent
        Agent agent = Airport.getInstance().getAgents().get(0);
        //removes agent from the list
        //list is now empty
        Airport.getInstance().getAgents().remove(agent);
        //tells the agent to leave a counter and just go back to floating around
        //agent goes back in the list
        agent.leaveCounter();
        assertTrue(!Airport.getInstance().getAgents().isEmpty());
    }
}