package tests;

import airville.gamepieces.counters.Counter;
import airville.gamepieces.counters.RegularCounter;
import airville.gamepieces.Supervisor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Nathaniel on 11/19/2015.
 */
public class SupervisorTest {

    @Test
    public void testSpeedUp() throws Exception {
        Supervisor supervisor = new Supervisor();
        Counter counter = new RegularCounter();
        supervisor.speedUp(counter);
        assertTrue(2 == counter.getProcessSpeed());
    }

    @Test
    public void testSlowDown() throws Exception {
        Supervisor supervisor = new Supervisor();
        Counter counter = new RegularCounter();
        supervisor.slowDown(counter);
        assertTrue(counter.getProcessSpeed() == 0.5);
    }
}