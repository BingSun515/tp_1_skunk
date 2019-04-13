import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDie 

{
	private Die die;
	
	@Before
	public void setUp() throws Exception
	{
		int[] init_values = new int[] { 3, 2, 1 };
		die = new Die(init_values);
	}

	@After
	public void tearDown() throws Exception
	{
	}
	//#############################################
	@Test
	public void DieTest() {
		die = new Die();
		die.roll();
	}
	//###############################################

	@Test
	public void test_initialization_of_predictable_die()
	{
		die.roll();
		int value = die.getLastRoll();

		assertEquals(3, value);
	}

	@Test
	public void test_roll_2_of_predictable_die()
	{
		die.roll();
		assertEquals(3, die.getLastRoll());
		die.roll();
		assertEquals(2, die.getLastRoll());

	}

	@Test
	public void test_roll_3_of_predictable_die()
	{
		die.roll();
		die.roll();
		die.roll();
		assertEquals(1, die.getLastRoll());
	}

	@Test
	public void test_roll_4_of_predictable_die_with3_rolls()
	{
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals(3, die.getLastRoll());
	}
	
	@Test
	public void test_roll_5_of_predictable_die_with3_rolls()
	{
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		die.roll();
		assertEquals(2, die.getLastRoll());
	}
	
	@Test(expected=RuntimeException.class)
	public void test_null_initial_int_array()
	{ 
		Die die = new Die(null);
	}
	
	@Test(expected=RuntimeException.class)
	public void test_empty_initial_array()
	{
		Die die = new Die(new int[] {});
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Die: "+ 0, die.toString());
	}
}