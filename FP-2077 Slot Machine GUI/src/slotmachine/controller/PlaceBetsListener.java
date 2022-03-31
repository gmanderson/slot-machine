package slotmachine.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;
import slotmachine.model.SlotMachine;
import slotmachine.model.slots.LineNum;
import slotmachine.view.PlaceBetDialogue;

public class PlaceBetsListener implements ActionListener
{
	private PlaceBetDialogue placeBetDialogue;
	private SlotMachine sm;

	public PlaceBetsListener(PlaceBetDialogue placeBetDialogue, SlotMachine sm)
	{
		this.placeBetDialogue = placeBetDialogue;
		this.sm = sm;
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		int betAmount = 0;
		try
		{
			betAmount = Integer.parseInt(placeBetDialogue.getBetAmount().getText());
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, "Amount may not be blank", "Error", 0);
		}
		

		boolean line1bet = placeBetDialogue.getLine1State();
		boolean line2bet = placeBetDialogue.getLine2State();
		boolean line3bet = placeBetDialogue.getLine3State();
		boolean line4bet = placeBetDialogue.getLine4State();
		boolean line5bet = placeBetDialogue.getLine5State();

		Set<LineNum> lines = new HashSet<>();

		if (line1bet)
			lines.add(LineNum.LINE1);

		if (line2bet)
			lines.add(LineNum.LINE2);

		if (line3bet)
			lines.add(LineNum.LINE3);

		if (line4bet)
			lines.add(LineNum.LINE4);

		if (line5bet)
			lines.add(LineNum.LINE5);
		try
		{
			sm.placeBet(betAmount, lines);
		} catch (Exception exception)
		{
			JOptionPane.showMessageDialog(null, exception.getMessage(), "Error", 0);
		}

		placeBetDialogue.resetFields();

		placeBetDialogue.dispose();

	}

}
