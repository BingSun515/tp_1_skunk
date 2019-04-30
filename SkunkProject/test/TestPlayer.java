import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerGetName() 
	{
		Player p1 = new Player("Eric");
		assertEquals("Eric", p1.getName()); 
	}
	
//	@Test//(expected=NullPointerException.class)
//	public void PlayeraddgetRound() 
//	{
//		Player p1 = new Player("Eric");
//		Round r1 = new Round(123);
//		p1.addRound(null);
//		assertEquals(0 ,p1.getRoundScore());
//	}

}
