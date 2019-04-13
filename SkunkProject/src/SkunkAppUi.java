import org.apache.commons.text.TextStringBuilder;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

class SkunkAppUi {

	private GameController controller = new GameController();
	private String playerName = "";

	SkunkAppUi()
	{		
	}

	static boolean getPlayerRollChoice()
	{
		String message = "\nDo you like to roll again ? ";
		return SkunkAppUi.getPlayerInput(message);
	}
	
	private static boolean getPlayerInput(String message)
	{
		SkunkAppUi.displayMessage(message);
		String playerInput;
		playerInput = StdIn.readLine();
		return playerInput.trim().equalsIgnoreCase("y");
	}

	static void displayResults(String message)
	{
		SkunkAppUi.displayMessage(message);
	}
	
	
	
	void startGame()
	{
		this.displayGameStart();
		this.setPlayerNameFromInput();
		this.controller.startGame(this.playerName);
	}

	private static void displayMessage(String message)
	{
		StdOut.print(message);
	}

	private void displayGameStart()
	{
		TextStringBuilder tb = new TextStringBuilder();
		tb.appendln("Game of Skunk. Welcome!");
		tb.appendln("Enter a player name : ");
		SkunkAppUi.displayMessage(tb.toString());
	}
		
	private void setPlayerNameFromInput()
	{
		String userInput = StdIn.readLine();
		this.playerName = userInput;
	}
	
}
