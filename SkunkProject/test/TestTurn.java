import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class TestTurn {	
	
	private ArrayList<Roll> rolls;
	private ArrayList<Score> turnScores;
	
	@Before
	public void setUp() {
		rolls = new ArrayList<>();
		turnScores = new ArrayList<>();
		rolls.add(new Roll());
		turnScores.add(new Score());
	}
	
	
//	@Test
//	public void testSetGet() {
//		Turn t1 = new Turn();
//		t1.rollAndSetScore();
//		
//	}
	

}
