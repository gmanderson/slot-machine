package slotmachine.view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JToolBar;
import slotmachine.controller.OpenDialogueListener;
import slotmachine.controller.SpinListener;
import slotmachine.controller.WinningOddsDialogueListener;
import slotmachine.model.SlotMachine;
import slotmachine.model.TurnDelayParameters;

/**
 * The Toolbar for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Toolbar on the main window containing buttons for
 * common gaming functions. Button functionality is currently unimplemented.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class ToolBar extends JToolBar
{
	public ToolBar(SlotMachine sm, RegisterDialogue registerDialogue, WinningOddsDialogue winningOddsDialogue,
			ResultsDialogue resultsDialogue, TurnDelayParameters turnDelayParameters, CashOutDialogue cashOutDialogue)
	{
		super("Button Toolbar");

		setFloatable(false);
		setLayout(new GridLayout(1, 10));

		JButton register = new JButton("Register Player");
		add(register);

		JButton cashOut = new JButton("Cash Out");
		add(cashOut);

		JButton results = new JButton("Results");
		add(results);

		JButton odds = new JButton("Winning Odds");
		add(odds);

		JButton spin = new JButton("SPIN!");
		spin.setBackground(new Color(150, 250, 120));
		add(spin);

		cashOut.addActionListener(new OpenDialogueListener(cashOutDialogue));

		register.addActionListener(new OpenDialogueListener(registerDialogue));

		odds.addActionListener(new WinningOddsDialogueListener(winningOddsDialogue));

		spin.addActionListener(new SpinListener(sm, turnDelayParameters));

		results.addActionListener(new OpenDialogueListener(resultsDialogue));

	}
}
