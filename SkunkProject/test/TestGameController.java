import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.Test;

public class TestGameController {

	@Test
	public void setPlayer1() {
		GameController gc1 = new GameController();
		gc1.setPlayer("Eric");
		assertEquals("Eric", gc1.getPlayerName());
	}
	
//	@Test
//	public void testStartGame() {
//		GameController gc2 = new GameController();
//		gc2.startGame();
//		
//		
//	}
		
}
