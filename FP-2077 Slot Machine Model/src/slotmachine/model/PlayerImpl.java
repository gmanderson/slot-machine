package slotmachine.model;

public class PlayerImpl implements Player
{
	private String id;
	private String name;
	private int initialCredits;
	private int creditsBalance;
	private int bet;

	public PlayerImpl(String id, String name, int initialCredits)
	{
		if ((id == null) || id.isEmpty())
			throw new IllegalArgumentException(String.format("Player id \"%s\" is invalid", id));

		if ((name == null) || name.isEmpty())
			throw new IllegalArgumentException(String.format("Player name \"%s\" is invalid", name));

		if (initialCredits < 0)
			throw new IllegalArgumentException(String.format("Initial credits are invalid. Must be greater than 0."));

		if (id.length()!=6)
			throw new IllegalArgumentException(String.format("Player id \"%s\" is invalid", id));
			
		for (int i = 0; i < 5; i++)
		{
			if (!Character.isDigit(id.charAt(i)))
				throw new IllegalArgumentException(String.format("Player id \"%s\" is invalid", id));
		}

		if (!Character.isLetter(id.charAt(5)))
			throw new IllegalArgumentException(String.format("Player id \"%s\" is invalid", id));

		this.id = id;
		this.name = name;
		this.initialCredits = initialCredits;
		this.creditsBalance = this.initialCredits;
		this.bet = 0;

	}

	public String getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public int getInitalCredits()
	{
		return this.initialCredits;
	}

	public int getCredits()
	{
		return this.creditsBalance;
	}

	public int getAvailableCredits()
	{
		return creditsBalance - this.bet;
	}

	public void addCredits(int credits)
	{
		this.creditsBalance += credits;
	}

	public int getBet()
	{
		return this.bet;
	}

	public void setBet(int bet)
	{
		this.bet = bet;
	}

	public void resetBet()
	{
		this.bet = 0;
	}

	public void applyWin(int winAmount)
	{
		if (winAmount > 0)
		{
			this.creditsBalance += winAmount;
		} else
		{
			this.creditsBalance -= this.bet;
		}

	}

	@Override
	public String toString()
	{
		return String.format("Player %s, %s, credits %d, bet %d, available %d", id, name, creditsBalance, bet,
				getAvailableCredits());
	}
}
