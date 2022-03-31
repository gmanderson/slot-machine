package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;
import slotmachine.model.TurnDelayParameters;

public class SpinListener implements ActionListener
{

	private SlotMachine sm;
	private TurnDelayParameters turnDelayParameters;

	public SpinListener(SlotMachine sm, TurnDelayParameters turnDelayParameters)
	{
		this.sm = sm;
		this.turnDelayParameters = turnDelayParameters;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		new Thread()
		{

			@Override
			public void run()
			{
				try
				{
					sm.spinToWin(turnDelayParameters.getTurns(), turnDelayParameters.getDelay());
				} catch (Exception exception)
				{
					JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", 0);
				}

			}
		}.start();

	}

}
