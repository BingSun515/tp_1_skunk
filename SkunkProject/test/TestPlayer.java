import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer {

	@Test
	public void PlayerSetGetTest() 
	{
		Player p1 = new Player("Eric");
		assertEquals("Eric", p1.getPlayerName()); 
	}
	
	@Test
	public void PlayerActiveTest() 
	{
		Player p1 = new Player("Eric");
		p1.setPlayerActive();
		assertEquals(p1.isPlayerActive(), true);
	}

}
