

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class JUnitTests.
 *
 * @author darshit
 * @version 09-24-2016
 */
public class JUnitTests
{
    /**
     * Default constructor for test class JUnitTests
     */
    GumballMachine gumballMachine;
    
    public JUnitTests()
    {
        gumballMachine = new GumballMachine(5);
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
	public void testInsertQuarter() {
		gumballMachine.insertQuarter();
		assertEquals(gumballMachine.getInsertedAmount(), 25);
	}
	
	@Test
	public void testInsertDime() {
		gumballMachine.insertDime();
		assertEquals(gumballMachine.getInsertedAmount(), 10);
	}
	
	@Test
	public void testInsertNickel() {
		gumballMachine.insertNickel();
		assertEquals(gumballMachine.getInsertedAmount(), 5);
	}
	
	@Test
	public void testTurnCrank() {
		gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		assertEquals(gumballMachine.getGumballCountInSlot(), 1);
	}
	
	@Test
	public void testIsGumballInSlot() {
	    gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		assertTrue(gumballMachine.isGumballInSlot());
	}
	
	@Test
	public void testTakeGumballFromSlot() {
	    gumballMachine.insertQuarter();
		gumballMachine.insertQuarter();
		gumballMachine.turnCrank();
		gumballMachine.takeGumballFromSlot();
		assertFalse(gumballMachine.isGumballInSlot());
	}
}
