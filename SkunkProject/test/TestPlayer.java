import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerGetName() 
	{
		Player p1 = new Player("Eric");
		assertEquals("Eric", p1.getName()); 
	}
	
	@Test
	public void testGetRoundScore() 
	{
		Player p1 = new Player("Eric");
		p1.addRound(null);
	}

}
