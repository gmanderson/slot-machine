package slotmachine.model;

public class TurnDelayParameters
{
	private int turns;
	private int delay;

	public void setTurns(int turns)
	{
		this.turns = turns;
	}

	public int getTurns()
	{
		return turns;
	}

	public void setDelay(int delayms)
	{
		this.delay = delayms;

	}

	public int getDelay()
	{
		return delay;
	}
}
