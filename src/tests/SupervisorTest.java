package tests;

import airville.Counter;
import airville.RegularCounter;
import airville.Supervisor;
import org.junit.Test;
import org.omg.CORBA.Object;

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