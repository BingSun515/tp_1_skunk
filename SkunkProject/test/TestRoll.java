import static org.junit.Assert.*;

import org.junit.Test;

public class TestRoll {

	@Test
	public void DoubleSkunktest() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void DoubleSkunktest2() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void DeuceSkunktest() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void DeuceSkunktestTest2() 
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {2});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void SingleSkunkTest() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(true, d1.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void SingleSkunkTest2() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollSingleSkunk());
	}
	
	
	@Test
	public void SingleSkunkTest3() 
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice d1 = new Dice(die1, die2);
		d1.roll();
		assertEquals(false, d1.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void testGetSkunk()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(SkunkEnum.SingleSkunk, r1.getSkunk());
	}
	
	@Test
	public void getDiceDisplay()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals("Dice with last roll: 4 => 1 + 3", r1.getDiceDisplay());
	}
	
	@Test
	public void getDiceLastRoll()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(4, r1.getDiceLastRoll());
	}
	
	@Test
	public void testisDoubleSkunk()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(true, r1.isDoubleSkunk());
	}
	
	@Test
	public void testisDoubleSkunk2()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(false, r1.isDoubleSkunk());
	}
	
	@Test
	public void testisDeuceSkunk()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(true, r1.isDeuceSkunk());
	}
	
	@Test
	public void testisDeuceSkunk2()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(false, r1.isDeuceSkunk());	
	}
	
	@Test
	public void testisSingleSkunk()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(true, r1.isSingleSkunk());
	}
	
	@Test
	public void testisSingleSkunk2()
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(false, r1.isSingleSkunk());
	}
	
	@Test
	public void testisSkunk()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(true, r1.isSkunk());
	}
	
	@Test
	public void testisSkunk2()
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(false, r1.isSkunk());
	}

}
