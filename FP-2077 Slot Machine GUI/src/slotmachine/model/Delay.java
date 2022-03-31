package slotmachine.model;

public enum Delay
{
	FAST("Fast",50),
	DEFAULT("Default", 100),
	SLOW("Slow", 250),
	VERYSLOW("Very Slow",1000);

	private String label;
	private int delayms;
	
	
	Delay(String label, int i)
	{
		this.delayms = i;
		this.label = label;
	}


	public int getDelayms()
	{
		return delayms;
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
