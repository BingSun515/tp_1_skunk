import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDice {
	
	@Test
	public void testDiceClass() {
		Dice d1 = new Dice();
		d1.roll();
	}
	
	
	@Test
	public void Dice_roll_once_oneNumber_equals_lastRoll_total()
	{
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {4});
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		
		assertEquals(7, dice.getLastRoll());		
	}
	
	@Test
	public void Dice_roll_twice_twonumbers_equals_lastRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4});
		Die die2 = new Die(new int[] {1, 2});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		assertEquals(4, dice.getLastRoll());
		
		dice.roll();
		assertEquals(6, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Thrice_twonumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4});
		Die die2 = new Die(new int[] {1, 2});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		assertEquals(4, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Thrice_threenumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4, 6});
		Die die2 = new Die(new int[] {1, 2, 3});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		assertEquals(9, dice.getLastRoll());
	}
	
	@Test
	public void Dice_roll_Fourtimes_FourandThreenumbers_equals_provides_firstRoll_total()
	{
		Die die1 = new Die(new int[] {3, 4, 5, 6});
		Die die2 = new Die(new int[] {1, 2, 3});
		
		Dice dice = new Dice(die1, die2);
		
		dice.roll();
		dice.roll();		
		dice.roll();
		dice.roll();
		assertEquals(7, dice.getLastRoll());
	}
	
	@Test
	public void test_to_string() {
		Die die1 = new Die(new int[] {1,2,3});
		Die die2 = new Die(new int[] {2,3,4});

		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals("Dice with last roll: 3 => 1 + 2", dice.toString());
	}
	
//	@Test(expected=RuntimeException.class)
//	public void Dice_roll_once_OneEmptyArrayInitializer_throws_ArrayIndexOutOfBoundsException()
//	{
//		Die die1 = new Die(new int[] {3, 4});
//		Die die2 = new Die(new int[] {});
//		
//		Dice dice = new Dice(die1, die2);		
//		dice.roll();
//	}
//	
//	@Test(expected=RuntimeException.class)
//	public void Dice_roll_once_NullInitializer_throws_RuntimeException()
//	{	
//		Dice dice = new Dice(null, null);		
//		dice.roll();
//	}
	
	@Test
	public void isSingleSkunk()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(false, dice.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void isSingleSkunk2()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(false, dice.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void isSingleSkunk3()
	{	
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(false, dice.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void isSingleSkunk4()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(true, dice.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void isSingleSkunk5()
	{	
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(true, dice.isDiceLastRollSingleSkunk());
	}
	
	@Test
	public void isDoubleSkunk()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(true, dice.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void isDoubleSkunk2()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(false, dice.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void isDoubleSkunk3()
	{	
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(false, dice.isDiceLastRollDoubleSkunk());
	}
	
	@Test
	public void isDeuceSkunk()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(true, dice.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void isDeuceSkunk2()
	{	
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(true, dice.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void isDeuceSkunk3()
	{	
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(false, dice.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void isDeuceSkunk4()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(false, dice.isDiceLastRollDeuceSkunk());
	}
	
	@Test
	public void getSingleSkunkTest()
	{
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(SkunkEnum.SingleSkunk, dice.getSkunk());
	}
	
	@Test
	public void getDoubleSkunkTest()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		assertEquals(SkunkEnum.DoubleSkunk, dice.getSkunk());
	}
	
	@Test
	public void getDeuceSkunkTest()
	{	
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(SkunkEnum.DeuceSkunk, dice.getSkunk());
	}
	
	@Test
	public void getNoSkunkTest()
	{	
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {4});
		Dice dice = new Dice(die1, die2);	
		dice.roll();
		assertEquals(SkunkEnum.NoSkunk, dice.getSkunk());
	}
	
	@Test
	public void testSetDie()
	{
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		assertEquals(SkunkEnum.NoSkunk, r1.getSkunk());
	}
	
}
