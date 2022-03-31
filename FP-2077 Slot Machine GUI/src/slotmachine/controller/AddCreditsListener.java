package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;
import slotmachine.view.AddCreditsDialogue;

public class AddCreditsListener implements ActionListener
{

	private AddCreditsDialogue addCreditsDialogue;
	private SlotMachine sm;

	public AddCreditsListener(AddCreditsDialogue addCreditsDialogue, SlotMachine sm)
	{
		this.addCreditsDialogue = addCreditsDialogue;
		this.sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int numCredits = 0;
		try
		{
			numCredits = Integer.parseInt(addCreditsDialogue.getNumCreditsField().getText());

		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "Credits must be greater than 0", "Error", 0);
		}

		try
		{

			sm.addCredits(numCredits);

		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", 0);
		}

		addCreditsDialogue.resetFields();
		addCreditsDialogue.dispose();

	}

}
