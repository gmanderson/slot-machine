package slotmachine.model;

public enum NumberTurns
{
	QUICK("Quick", 5),
	SHORT("Short", 10),
	DEFAULT("Default", 20),
	LONG("Long", 50);

	private String label;
	private int numberOfTurns;
	
	NumberTurns(String label, int i)
	{
		this.numberOfTurns = i;
		this.label = label;
	}


	public int getNumberOfTurns()
	{
		return numberOfTurns;
	}
	
	
	public String getLabel()
	{
		return label;
	}

	@Override
	public String toString()
	{
		return label;
	}
	
	
}
