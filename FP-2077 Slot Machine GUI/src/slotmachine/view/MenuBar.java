package slotmachine.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import slotmachine.controller.DelayListener;
import slotmachine.controller.OpenDialogueListener;
import slotmachine.controller.SpinListener;
import slotmachine.controller.TurnsListener;
import slotmachine.model.SlotMachine;
import slotmachine.model.TurnDelayParameters;

/**
 * The menu bar for <b>Slot Machine</b>.
 * <p>
 * This class constructs menus, menu items, mnemonics and key accelerators in
 * the menu bar. Dialogue boxes are initialised here and listeners on them to
 * provide functionality.
 * </p>
 *
 * @see slotmachine.view.AboutDialogue
 * @see slotmachine.view.RegisterDialogue
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class MenuBar extends JMenuBar
{

	public MenuBar(SlotMachine sm, RegisterDialogue registerDialogue, WinningOddsDialogue winningOddsDialogue,
			TurnDelayParameters turnDelayParameters, CashOutDialogue cashOutDialogue, GuiCallBack guiCallBack, 
			ResultsDialogue resultsDialogue, AddCreditsDialogue addCreditsDialogue, PlaceBetDialogue placeBetDialogue)
	{

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		add(file);

		JMenuItem quit = new JMenuItem("Quit");
		quit.setMnemonic(KeyEvent.VK_X);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		file.add(quit);

		JMenu game = new JMenu("Game");
		game.setMnemonic(KeyEvent.VK_G);
		add(game);

		JMenuItem register = new JMenuItem("Register Player");
		register.setMnemonic(KeyEvent.VK_P);
		register.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		game.add(register);

		JMenuItem cashOut = new JMenuItem("Cash Out Player");
		cashOut.setMnemonic(KeyEvent.VK_O);
		cashOut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		game.add(cashOut);

		game.addSeparator();
		JMenuItem placeBet = new JMenuItem("Place Bet");
		placeBet.setMnemonic(KeyEvent.VK_B);
		placeBet.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
		game.add(placeBet);

		JMenuItem addCredits = new JMenuItem("Add Credits");
		addCredits.setMnemonic(KeyEvent.VK_C);
		addCredits.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		game.add(addCredits);

		game.addSeparator();
		JMenuItem results = new JMenuItem("Results");
		results.setMnemonic(KeyEvent.VK_R);
		results.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		game.add(results);

		JMenuItem previousOutcomes = new JMenuItem("Previous Outcomes");
		previousOutcomes.setMnemonic(KeyEvent.VK_V);
		previousOutcomes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		game.add(previousOutcomes);

		JMenuItem odds = new JMenuItem("Winning Odds");
		odds.setMnemonic(KeyEvent.VK_W);
		odds.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
		game.add(odds);

		game.addSeparator();
		JMenuItem spin = new JMenuItem("SPIN!");
		spin.setMnemonic(KeyEvent.VK_S);
		spin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		game.add(spin);

		JMenu spinParameters = new JMenu("Spin Parameters");
		spinParameters.setMnemonic(KeyEvent.VK_R);
		add(spinParameters);

		JMenu numberTurns = new JMenu("Number of Turns");
		spinParameters.add(numberTurns);

		JRadioButtonMenuItem quickTurns = new JRadioButtonMenuItem("Quick");
		numberTurns.add(quickTurns);

		JRadioButtonMenuItem shortTurns = new JRadioButtonMenuItem("Short");
		numberTurns.add(shortTurns);

		JRadioButtonMenuItem defaultTurns = new JRadioButtonMenuItem("Default");

		numberTurns.add(defaultTurns);

		JRadioButtonMenuItem longTurns = new JRadioButtonMenuItem("Long");
		numberTurns.add(longTurns);

		ButtonGroup turnGroup = new ButtonGroup();
		turnGroup.add(quickTurns);
		turnGroup.add(shortTurns);
		turnGroup.add(defaultTurns);
		turnGroup.add(longTurns);

		JMenu turnDelay = new JMenu("Turn Delay");
		spinParameters.add(turnDelay);

		JRadioButtonMenuItem fastDelay = new JRadioButtonMenuItem("Fast");
		turnDelay.add(fastDelay);

		JRadioButtonMenuItem defaultDelay = new JRadioButtonMenuItem("Default");
		turnDelay.add(defaultDelay);

		JRadioButtonMenuItem slowDelay = new JRadioButtonMenuItem("Slow");
		turnDelay.add(slowDelay);

		JRadioButtonMenuItem verySlowDelay = new JRadioButtonMenuItem("Very Slow");
		turnDelay.add(verySlowDelay);

		ButtonGroup delayGroup = new ButtonGroup();
		delayGroup.add(fastDelay);
		delayGroup.add(defaultDelay);
		delayGroup.add(slowDelay);
		delayGroup.add(verySlowDelay);

		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		add(help);

		JMenuItem about = new JMenuItem("About");
		about.setMnemonic(KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		help.add(about);

		AboutDialogue aboutDialogue = new AboutDialogue();

		PreviousOutcomesDialogue previousOutcomesDialogue = new PreviousOutcomesDialogue(guiCallBack);

		register.addActionListener(new OpenDialogueListener(registerDialogue));

		about.addActionListener(new OpenDialogueListener(aboutDialogue));

		odds.addActionListener(new OpenDialogueListener(winningOddsDialogue));

		previousOutcomes.addActionListener(new OpenDialogueListener(previousOutcomesDialogue));

		cashOut.addActionListener(new OpenDialogueListener(cashOutDialogue));

		results.addActionListener(new OpenDialogueListener(resultsDialogue));

		placeBet.addActionListener(new OpenDialogueListener(placeBetDialogue));

		addCredits.addActionListener(new OpenDialogueListener(addCreditsDialogue));

		defaultTurns.addActionListener(new TurnsListener(turnDelayParameters));
		quickTurns.addActionListener(new TurnsListener(turnDelayParameters));
		shortTurns.addActionListener(new TurnsListener(turnDelayParameters));
		longTurns.addActionListener(new TurnsListener(turnDelayParameters));
		defaultTurns.doClick();

		fastDelay.addActionListener(new DelayListener(turnDelayParameters));
		defaultDelay.addActionListener(new DelayListener(turnDelayParameters));
		slowDelay.addActionListener(new DelayListener(turnDelayParameters));
		verySlowDelay.addActionListener(new DelayListener(turnDelayParameters));
		defaultDelay.doClick();

		spin.addActionListener(new SpinListener(sm, turnDelayParameters));

		quit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});

	}
}
