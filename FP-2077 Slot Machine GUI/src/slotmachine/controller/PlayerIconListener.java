package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import slotmachine.view.RegisterDialogue;

public class PlayerIconListener implements ActionListener
{

	private RegisterDialogue registerDialogue;

	public PlayerIconListener(RegisterDialogue registerDialogue)
	{
		this.registerDialogue = registerDialogue;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{

		if (e.getActionCommand() == "Astronaut")
		{
			registerDialogue.setPlayerIcon(e.getActionCommand());
		}

		if (e.getActionCommand() == "Clown")
			registerDialogue.setPlayerIcon(e.getActionCommand());

		if (e.getActionCommand() == "Hacker")
			registerDialogue.setPlayerIcon(e.getActionCommand());

		if (e.getActionCommand() == "Monster")
			registerDialogue.setPlayerIcon(e.getActionCommand());

	}

}
