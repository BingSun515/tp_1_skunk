import java.util.ArrayList;
import java.util.Iterator;

class Turn {
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
	
//	public void setLastRoll(Roll lastRoll)
//	{
//		this.rolls.add(lastRoll);
//	}
	
	public Roll getLastRoll()
	{
		if (this.rolls.size() -1 > -1)
		{
			return this.rolls.get(this.rolls.size() -1 );
		}
		else
		{
			return null;
		}
	}
	
	void rollAndSetScore()
	{
		this.newRoll();
		this.setScore();
	}

	private void newRoll()
	{
		this.rolls.add(new Roll());
	}
	
	private void setScore()
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
		Score nextScore;
		Iterator<Score> scores = this.turnScores.iterator();
		while(scores.hasNext())
		{ 
			nextScore = scores.next();
			score.setTurnScore(nextScore.getTurnScore(), nextScore.getChipChangeScore(), nextScore.getKittyChangeScore());
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
