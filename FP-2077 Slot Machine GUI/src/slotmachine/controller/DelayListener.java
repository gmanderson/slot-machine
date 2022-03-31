package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import slotmachine.model.Delay;
import slotmachine.model.TurnDelayParameters;

public class DelayListener implements ActionListener
{
	private TurnDelayParameters turnDelayParameters;

	public DelayListener(TurnDelayParameters turnDelayParameters)
	{
		this.turnDelayParameters = turnDelayParameters;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand() == Delay.FAST.getLabel())
			turnDelayParameters.setDelay(Delay.FAST.getDelayms());

		if (e.getActionCommand() == Delay.DEFAULT.getLabel())
			turnDelayParameters.setDelay(Delay.DEFAULT.getDelayms());

		if (e.getActionCommand() == Delay.SLOW.getLabel())
			turnDelayParameters.setDelay(Delay.SLOW.getDelayms());

		if (e.getActionCommand() == Delay.VERYSLOW.getLabel())
			turnDelayParameters.setDelay(Delay.VERYSLOW.getDelayms());
	}

}
