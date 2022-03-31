package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;

public class ResetBetsListener implements ActionListener
{
	private SlotMachine sm;

	public ResetBetsListener(SlotMachine sm)
	{
		this.sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			sm.resetBets();
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "No registered player", "Error", 0);
		}

	}

}
