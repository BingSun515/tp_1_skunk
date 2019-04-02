import java.util.ArrayList;
import java.util.Iterator;

public class Turn {
	private final int DOUBLE_SKUNK_CHIP = -4; 
	private final int DOUBLE_SKUNK_KITTY = 4;

	private final int DEUCE_SKUNK_CHIP = -2; 
	private final int DEUCE_SKUNK_KITTY = 2;
	
	private final int SINGLE_SKUNK_CHIP = -1; 
	private final int SINGLE_SKUNK_KITTY = 1;

	private ArrayList<Roll> rolls;
	private ArrayList<Score> turnScores;

	public Turn()
	{
		this.rolls = new ArrayList<Roll>();
		this.turnScores = new ArrayList<Score>();
	}
	
	public void setLastRoll(Roll lastRoll)
	{
		this.rolls.add(lastRoll);
	}
	
	public Roll getLastRoll()
	{
		if (this.rolls.size() -1 > 0)
		{
			return this.rolls.get(this.rolls.size() -1 );
		}
		else
		{
			return null;
		}
	}
	
	public void newRoll()
	{
		this.rolls.add(new Roll());
	}
	
	public void setScore()
	{
		if (this.getLastRoll().isSkunk())
		{
			this.setSkunkScore();
		}
		else
		{
			this.setTurnScore();
		}
	}

	private void setTurnScore()
	{
		Score score = new Score(this.getLastRoll().getDiceLastRoll());
		turnScores.add(score);
	}
	
	public Score getTurnScore()
	{
		Score score = new Score();
		Iterator<Score> scores = this.turnScores.iterator();
		while(scores.hasNext())
		{
			score.setTurnScore(scores.next().getTurnScore(), scores.next().getChipChangeScore(), scores.next().getKittyChangeScore());
		}
		return score;
	}

	private void setSkunkScore()
	{
		Score score = null;
		if (this.getLastRoll().isDoubleSkunk())
		{
			score = new Score(0, this.DOUBLE_SKUNK_CHIP, this.DOUBLE_SKUNK_KITTY);
		}
		else if (this.getLastRoll().isDeuceSkunk())
		{
			score = new Score(0, this.DEUCE_SKUNK_CHIP, this.DEUCE_SKUNK_KITTY);
		}
		else if (this.getLastRoll().isSingleSkunk())
		{
			score = new Score(0, this.SINGLE_SKUNK_CHIP, this.SINGLE_SKUNK_KITTY);
		}
		turnScores.add(score);
	}

	
}
