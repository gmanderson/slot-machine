package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;
import slotmachine.view.RegisterDialogue;

public class RegisterPlayerListener implements ActionListener
{
	RegisterDialogue registerDialogue;
	SlotMachine sm;

	public RegisterPlayerListener(RegisterDialogue registerDialogue, SlotMachine sm)
	{
		super();
		this.registerDialogue = registerDialogue;
		this.sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String playerID = registerDialogue.getPlayerIDField().getText();
		String playerName = registerDialogue.getPlayerNameField().getText();
		int initialCredits = 0;

		try
		{
			initialCredits = Integer.parseInt((registerDialogue.getInitialCreditsField().getText()));
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "Inital Credits may not be 0", "Error", 0);
		}

		try
		{
			sm.registerPlayer(playerID, playerName, initialCredits);
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", 0);
		}

		registerDialogue.resetFields();

		registerDialogue.dispose();
	}

}
