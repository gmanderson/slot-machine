package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;
import slotmachine.view.CashOutDialogue;

public class CashOutListener implements ActionListener
{
	private SlotMachine sm;
	private CashOutDialogue cashOutDialogue;

	public CashOutListener(CashOutDialogue cashOutDialogue, SlotMachine sm)
	{
		this.sm = sm;
		this.cashOutDialogue = cashOutDialogue;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			sm.cashOut();
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", 0);
		} finally
		{
			cashOutDialogue.resetCredits();
			cashOutDialogue.dispose();
			
		}
	}

}
