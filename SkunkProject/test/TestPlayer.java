import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerGetName() 
	{
		Player p1 = new Player("Eric");
		assertEquals("Eric", p1.getName()); 
	}
	
//	@Test
//	public void testGetRoundScore() 
//	{
//		Player p1 = new Player("Eric");
//		Turn t1 = new Turn();
//		Round r1 = new Round(t1);
//		assertEquals(123, p1.getRoundScore());
//	}

}
