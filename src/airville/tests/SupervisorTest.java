package airville.tests;

import airville.core.gamepieces.counters.Counter;
import airville.core.gamepieces.counters.RegularCounter;
import airville.core.gamepieces.Supervisor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests the Supervisor class.
 */
public class SupervisorTest {

    /**
     * Tests the speedUp() routine in Supervisor.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testSpeedUp() throws Exception {
        Supervisor supervisor = new Supervisor();
        Counter counter = new RegularCounter();
        counter.setBusyTime(2);
        supervisor.speedUp(counter);
        assertTrue(1 == counter.getBusyTime());
    }

    /**
     * Tests the slowDown() routine in Supervisor.
     * @throws Exception An exception indicating this test case has failed.
     */
    @Test
    public void testSlowDown() throws Exception {
        Supervisor supervisor = new Supervisor();
        Counter counter = new RegularCounter();
        counter.setBusyTime(2);
        supervisor.slowDown(counter);
        assertTrue(4 == counter.getBusyTime());
    }
}