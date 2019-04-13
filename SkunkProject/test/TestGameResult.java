import static org.junit.Assert.*;

import org.apache.commons.text.TextStringBuilder;
import org.junit.Test;

public class TestGameResult {
	
	@Test
	public void testGameResultSingleSkunk() {
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals("Dice with last roll: 4 => 1 + 3\r\n" + 
				"-----------\r\n" + 
				"Last roll was a single skunk\r\n" + 
				"",GR.getRollScore());
	}
	
	@Test
	public void testGameResultDoubleSkunk() {
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {1});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals("Dice with last roll: 2 => 1 + 1\r\n" + 
				"-----------\r\n" + 
				"Last roll was a double skunk\r\n" + 
				"",GR.getRollScore());
	}
	
	@Test
	public void testGameResultDeuceSkunk() {
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals("Dice with last roll: 3 => 1 + 2\r\n" + 
				"-----------\r\n" + 
				"Last roll was a Deuce skunk\r\n" + 
				"",GR.getRollScore());
	}
	
	@Test
	public void testGameResultNoSkunk() {
		Die die1 = new Die(new int[] {2});
		Die die2 = new Die(new int[] {3});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals("Dice with last roll: 5 => 2 + 3\r\n" + 
				"-----------\r\n" + 
				"",GR.getRollScore());
	}
	
	@Test
	public void testGetGameStatus1() {
		Die die1 = new Die(new int[] {3});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals(GameStatusEnum.INPROGRESS, GR.getGameStatus());
	}
	
	@Test
	public void testGetGameStatus2() {
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		assertEquals(GameStatusEnum.TURN_COMPLETED, GR.getGameStatus());
	}
	
	@Test
	public void testGetGameSummary() {
		Die die1 = new Die(new int[] {1});
		Die die2 = new Die(new int[] {2});
		Roll r1 = new Roll();
		r1.setDice(die1, die2);
		GameResult GR = new GameResult(new Player("Eric"), r1);
		Score s1 = new Score(3, 4, 5);
		assertEquals("\r\n" + 
				"********** GAME SUMMARY **********\r\n" + 
				"turn score :: 3\r\n" + 
				"chip change :: 4\r\n" + 
				"kitty change :: 5\r\n" + 
				"", GR.getGameSummary(s1));
	}
	
}
