import java.util.ArrayList;

class GameController {
	
	private Turn turn;
	private ArrayList<Player> players = null;
	private GameStatusEnum status = GameStatusEnum.INPROGRESS;
	private GameResult result;

	GameController()
	{
	}
	
	public void setPlayer(String playerName)
	{
		if (this.players == null) 
		{
			this.players = new ArrayList<Player>();
		}
		this.players.add(new Player(playerName));
	}

	public Player getPlayer()
	{
		return this.players.get(0);
	}
	
	public String getPlayerName()
	{
		return this.getPlayer().getPlayerName();
	}
	
	void startGame(String playerName)
	{
		if (this.turn == null)
		{
			this.turn = new Turn();
		}
		this.setPlayer(playerName);
		this.startTurn();
		this.displayGameSummary();
	}

	private void startTurn()
	{
		while(this.status != GameStatusEnum.GAME_COMPLETED)
		{
			switch(this.status)
			{
				case INPROGRESS:
					this.turn.rollAndSetScore();
					this.result = new GameResult(this.getPlayer(), this.turn.getLastRoll());
					SkunkAppUi.displayResults(this.result.getRollScore());
					this.status = this.result.getGameStatus();
					break; 

				case TURN_COMPLETED:
					this.status = GameStatusEnum.GAME_COMPLETED;
					break;
				default:
						break;
			}
			
			if (this.status == GameStatusEnum.INPROGRESS && !SkunkAppUi.getPlayerRollChoice())
			{
				//DECLINED_TO_ROLL
				this.status = GameStatusEnum.TURN_COMPLETED;
			}
		}
	}
	
	private void displayGameSummary()
	{
		Score score = this.turn.getTurnScore();
		String message = this.result.getGameSummary(score);
		SkunkAppUi.displayResults(message);
	}
}
