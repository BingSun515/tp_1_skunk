import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.text.TextStringBuilder;

class GameController {

	private Turn turn;
	private ArrayList<Player> players = null;
	private Player activePlayer;
	private Player winner;

	private GameStatusEnum status = GameStatusEnum.INPROGRESS;
	private GameResult result;
	private int playerCount = 0;

	GameController() {
		this.loadUiMessages();
	}

	public void setPlayer(String playerName) {
		if (this.players == null) {
			this.players = new ArrayList<Player>();
		}
		this.players.add(new Player(playerName));
	}

	void startGame() {
		this.initializeNewGame();
		this.getPlayersCountInput();
		this.initializePlayers();
		this.startTurns();
		this.displayGameSummary();
	}

	private void initializeNewGame() {
		this.players = null;
		this.activePlayer = null;
		this.winner = null;
	}

	private void initializePlayers() {
		for (int i = 0; i < this.playerCount; i++) {
			String playerName = SkunkAppUi.getPlayerNameFromInput(String.valueOf(i + 1));
			this.setPlayer(playerName); // TODO: PERFORM VALIDATE PLAYER NAME
		}
	}

	private void startTurns() {
		Iterator<Player> player = this.players.iterator();
		while (player.hasNext()) {
			this.activePlayer = player.next();
			this.displayNextPlayer();
			this.turn = new Turn();
			if (this.status == GameStatusEnum.LAST_CHANCE) {
				this.continueTurn();
			} else {
				this.status = GameStatusEnum.INPROGRESS;
				this.startTurn();
			}
			// only one round needed for tp 1.3
			this.activePlayer.addRound(new Round(this.turn));
		}
	}

	private void startTurn() {
		while (this.turnCanContinue()) {
			this.continueTurn();
			this.setGameStatus();
			this.askPlayerRollChoice();
		}
	}

	private boolean turnCanContinue() {
		return ((this.status != GameStatusEnum.TURN_COMPLETED) && (this.status != GameStatusEnum.LAST_CHANCE));
	}

	private void continueTurn() {
		this.turn.rollAndSetScore();
		this.result = new GameResult(this.turn);
		SkunkAppUi.displayResults(this.result.getRollScore());
	}

	private void setGameStatus() {
		if (this.turn.getLastRoll().isSkunk()) {
			this.status = GameStatusEnum.TURN_COMPLETED;
		} else if (this.turn.isTurnScoreHigherThanWinningScore() && this.winner != null) {
			this.winner = this.activePlayer;
			this.status = GameStatusEnum.LAST_CHANCE;
		} else if (this.turn.isTurnScoreHigherThanWinningScore()) {
			this.status = GameStatusEnum.LAST_CHANCE;
		} else if (this.winner != null) {
			this.status = GameStatusEnum.LAST_CHANCE;
		} else {
			this.status = GameStatusEnum.INPROGRESS;
		}
	}

	private void askPlayerRollChoice() {
		if (this.status == GameStatusEnum.INPROGRESS && !this.getPlayerRollChoice()) {
			// DECLINED_TO_ROLL
			this.status = GameStatusEnum.TURN_COMPLETED;
		}
	}

	private void displayGameSummary() {
		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.getUiMessage("aDoubleLine"))
				.appendln(Constants.getUiMessage("gameSummary"));

		SkunkAppUi.displayResults(tb.toString());
		this.displayRoundSummary();
		this.displayWinner();
		tb = null;
	}

	private void displayRoundSummary() {
		Iterator<Player> player = this.players.iterator();
		Player nextPlayer;
		TextStringBuilder tb;
		while (player.hasNext()) {
			nextPlayer = player.next();
			Score score = nextPlayer.getRoundScore();
			String message = this.result.getGameSummary(score);
			tb = new TextStringBuilder().appendln(Constants.getUiMessage("aLine"))
					.appendln(Constants.getUiMessage("playerName") + nextPlayer.getName()).appendln(message);

			SkunkAppUi.displayResults(tb.toString());
		}
	}

	private boolean getPlayerRollChoice() {
		PlayerInputEnum playerChoice;
		do {
			playerChoice = this.getPlayerInputChoice(SkunkAppUi.getPlayerRollChoice());
			if (playerChoice == PlayerInputEnum.HELP) {
				this.displayHelp();
			}
		} while (playerChoice == PlayerInputEnum.HELP);
		return playerChoice == PlayerInputEnum.Y;
	}

	private PlayerInputEnum getPlayerInputChoice(String choice) {
		if (choice != null && !choice.trim().isEmpty()) {
			try {
				return PlayerInputEnum.valueOf(choice.toUpperCase());
			} catch (Exception e) {
				// if player entered a choice other than y / n / help, return N
				return PlayerInputEnum.N;
			}
		}
		return PlayerInputEnum.N;
	}

	private void displayHelp() {
		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.getUiMessage("aLine"))
				.appendln(Constants.getUiMessage("gameRules")).appendln(Constants.getUiMessage("aLine"))
				.appendln("1:Each letter of skunk represents a different round of the game; Total 5 rounds per Game.")
				.appendln("2:A player gets the total of the dice and records it in his or her turn")
				.appendln("3:If a \"one\" comes up, play is over for that round and all the player's points in that column are wiped out.") 
				.appendln("4:If \"double ones\" comes up, all points accumulated in prior columns are wiped out as well.")
				.appendln("5:If a \"one\" doesn't occur, the player may choose either to try for more points on the next roll or to stop and keep what he or she has accumulated.")
				.appendln("6:A skunk in any series draws a penalty of 1 chip placed in the \"kitty,\" and loss of dice.")
				.appendln("7:A skunk and a deuce draws a penalty of 2 chips placed in the \"kitty,\" and loss of dice.")
				.appendln("8:TWO skunks void the ENTIRE accumulated score and draws a penalty of 4 chips placed in the \"kitty,\" and loss of dice. Player must again start to score from scratch.")
				.appendln(Constants.getUiMessage("aLine"));
		SkunkAppUi.displayResults(tb.toString());
	}

	private void displayWinner() {
		String playerWinner = "No Winner for this round";
		if (this.winner != null) {
			playerWinner = Constants.getUiMessage("winner") + this.winner.getName(); 
		}
		TextStringBuilder tb = new TextStringBuilder("").appendln(Constants.getUiMessage("aLine"))
				.appendln(Constants.getUiMessage("aLine")).appendln(playerWinner);

		SkunkAppUi.displayResults(tb.toString());
	}

	private void displayNextPlayer() {
		TextStringBuilder tb = new TextStringBuilder().appendln(Constants.getUiMessage("aLine"))
				.appendln(Constants.getUiMessage("currentPlayer") + this.activePlayer.getName());
		SkunkAppUi.displayResults(tb.toString());
		tb = null;
	}

	private void getPlayersCountInput() {
		String inputMessage = Constants.getUiMessage("playerInput");
		this.playerCount = SkunkAppUi.getPlayerNumericInput(inputMessage);
	}
	//add new function######################################################
	public String getPlayerbyName(String name) {
		for (int i = 0 ; i < this.players.size()-1; i++) {
			if (this.players.get(i).getName()== name) {
				return this.players.get(i).getName();
			}
		}
		return null;
	}

// STATIC METHODS	
	// TODO: PHASE 2
	// MOVE ALL UI CONSTANTS TO CONSTANTS CLASS
	private void loadUiMessages() {
		Constants.addUiMessage("playerInput", "Enter the # of players : ");
		Constants.addUiMessage("aLine", "--------------------------------------------");
		Constants.addUiMessage("aDoubleLine", "===========================================");
		Constants.addUiMessage("currentPlayer", " :: Current PLAYER :: ");
		Constants.addUiMessage("playerName", "   PLAYER NAME:: ");
		Constants.addUiMessage("gameSummary", "               GAME SUMMARY               ");
		Constants.addUiMessage("gameRules", "               GAME RULES               ");
		Constants.addUiMessage("winner", " Winner is player, ");
	}
}
