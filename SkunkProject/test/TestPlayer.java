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
//	public void PlayeraddgetRound() 
//	{
//		Player p1 = new Player("Eric");
//		Round r1 =new Round();
//		Turn t1 = new Turn();
//		t1.
//		p1.addRound(null);
//		assertEquals(0 ,p1.getRoundScore());
//	}
	
//	@Test
//	public void testGetRoundScore() 
//	{
//		Player p1 = new Player("Eric");
//		Score s1 = new Score(50,100,150);
//		Turn t1 = new Turn();
//		Round r1 = new Round(t1);
//		t1.
//	}

}
