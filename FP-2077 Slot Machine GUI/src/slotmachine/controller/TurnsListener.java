package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import slotmachine.model.NumberTurns;
import slotmachine.model.TurnDelayParameters;

public class TurnsListener implements ActionListener
{
	private TurnDelayParameters turnDelayParameter;
	
	public TurnsListener(TurnDelayParameters turnDelayParameter)
	{
		this.turnDelayParameter = turnDelayParameter;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand() == NumberTurns.DEFAULT.getLabel())
			turnDelayParameter.setTurns(NumberTurns.DEFAULT.getNumberOfTurns());
		
		if(e.getActionCommand() == NumberTurns.QUICK.getLabel())
			turnDelayParameter.setTurns(NumberTurns.QUICK.getNumberOfTurns());
		
		if(e.getActionCommand() == NumberTurns.SHORT.getLabel())
			turnDelayParameter.setTurns(NumberTurns.SHORT.getNumberOfTurns());
		
		if(e.getActionCommand() == NumberTurns.LONG.getLabel())
			turnDelayParameter.setTurns(NumberTurns.LONG.getNumberOfTurns());
	}

}
