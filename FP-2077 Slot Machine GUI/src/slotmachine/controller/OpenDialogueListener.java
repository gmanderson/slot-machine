package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class OpenDialogueListener implements ActionListener
{
	private JFrame openDialogue;

	public OpenDialogueListener(JFrame openDialogue)
	{
		this.openDialogue = openDialogue;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		openDialogue.setVisible(true);

	}

}
