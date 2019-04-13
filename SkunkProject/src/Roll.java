class Roll {
	private Dice dice;

	public Roll()
	{
		this.dice = new Dice();
	}
	
	//####################################
	//testing method predictable dice
	public void setDice(Die die1, Die die2)
	{
		this.dice.setDie1(die1);
		this.dice.setDie2(die2);
		this.dice.roll();
	}
	
	//####################################
	public boolean isDoubleSkunk()
	{
		return this.getSkunk() == SkunkEnum.DoubleSkunk;
	}
	
	public boolean isDeuceSkunk()
	{
		return this.getSkunk() == SkunkEnum.DeuceSkunk;
	}

	public boolean isSingleSkunk()
	{
		return this.getSkunk() == SkunkEnum.SingleSkunk;
	}
	
	public boolean isSkunk()
	{
		return this.getSkunk() != SkunkEnum.NoSkunk;
	}

	public int getDiceLastRoll()
	{
		return this.dice.getLastRoll();
	}
	
	public String getDiceDisplay()
	{
		return this.dice.toString();
	}
	
	public SkunkEnum getSkunk()
	{
		return this.dice.getSkunk();
	}
}
