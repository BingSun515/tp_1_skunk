class Player {
	
	private Boolean isActive;
	private String playerName;
	
	Player(String name)
	{
		this.playerName = name;
	}
	
	public String getPlayerName()
	{
		return this.playerName;
	}
	
	public boolean isPlayerActive() {
		return isActive;
	}
	
	//TBD have some issue ####################################
	public void setPlayerActive() {
		isActive = true; 
	}
	
	//########################################################
	
}
