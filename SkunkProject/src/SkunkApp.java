import edu.princeton.cs.introcs.StdOut;
public class SkunkApp
{

	public static void main(String[] args)
	{
		StdOut.println("Thanks for playing our Skunk game. This game is under develop.");
		StdOut.println("Setting Die sequence. Die1 = 6,5,4 AND Die2 = 3,2,1.");
		
		Die die1 = new Die(new int[] {6,5,4});
		Die die2 = new Die(new int[] {3,2,1});
		Dice dice = new Dice(die1, die2);
		dice.roll();
		
		StdOut.println("die1 roll: " + die1.getLastRoll());
		StdOut.println("die2 roll: " + die2.getLastRoll());
		StdOut.println("dice roll: " + dice.getLastRoll());
		
	}	
}
