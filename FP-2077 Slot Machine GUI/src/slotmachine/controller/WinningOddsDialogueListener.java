package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import slotmachine.view.WinningOddsDialogue;

public class WinningOddsDialogueListener implements ActionListener
{

	private WinningOddsDialogue winningOddsDialogue;

	public WinningOddsDialogueListener(WinningOddsDialogue winningOddsDialogue)
	{
		this.winningOddsDialogue = winningOddsDialogue;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		winningOddsDialogue.setVisible(true);
	}

}
