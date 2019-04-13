import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameController {

	@Test
	public void setPlayer1() {
		GameController gc1 = new GameController();
		gc1.setPlayer("Eric");
		assertEquals("Eric", gc1.getPlayerName());
	}
	
	@Test
	public void setPlayer2() {
		GameController gc1 = new GameController();
		gc1.setPlayer(null);
		assertEquals(null, gc1.getPlayerName());
	}
	
	@Test
	public void testStartGame() {
		GameController gc1 = new GameController();
		gc1.startGame("Eric");
		assertEquals("Eric", gc1.getPlayer());
	}
		
}
