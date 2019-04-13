import static org.junit.Assert.*;

import org.junit.Test;

public class TestScore {
	
	@Test
	public void Score() {
		Score s1 = new Score();
		assertEquals(0, s1.getTurnScore());
		assertEquals(0, s1.getChipChangeScore());
		assertEquals(0, s1.getKittyChangeScore());
	}

	@Test
	public void ScoreInt() {
		Score s1 = new Score(100);
		assertEquals(100, s1.getTurnScore());
	}
	
	@Test
	public void ScorewithThreeInt() {
		Score s1 = new Score(50,100,150);
		assertEquals(50, s1.getTurnScore());
		assertEquals(100, s1.getChipChangeScore());
		assertEquals(150, s1.getKittyChangeScore());
	}
	
	@Test
	public void setTurnScore() {
		Score s1 = new Score(50,100,150);
		s1.setTurnScore(1, 2, 3);
		assertEquals(51, s1.getTurnScore());
		assertEquals(102, s1.getChipChangeScore());
		assertEquals(153, s1.getKittyChangeScore());
	}

}
