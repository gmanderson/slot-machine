package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import slotmachine.controller.WheelPanelResizeListener;
import slotmachine.model.SlotMachine;
import slotmachine.model.TurnDelayParameters;

/**
 * The main window frame for <b>Slot Machine</b>.
 * <p>
 * This class adds and positions the components of the main application window.
 * </p>
 * 
 * @see slotmachine.view.ToolBar
 * @see slotmachine.view.MenuBar
 * @see slotmachine.view.PlayerPanel
 * @see slotmachine.view.LineBetsPanel
 * @see slotmachine.view.StatusBar
 * @see slotmachine.view.WheelsPanel
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class MainWindow extends JFrame
{

	public MainWindow(SlotMachine sm, GuiCallBack guiCallBack)
	{
		super("Slot Machine");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setMinimumSize(new Dimension(885, 710));
		setMaximumSize(new Dimension(1170, 990));

		// Centres window to screen
		setLocationRelativeTo(null);

		setLayout(new GridBagLayout());

		RegisterDialogue registerDialogue = new RegisterDialogue(sm);
		WinningOddsDialogue winningOddsDialogue = new WinningOddsDialogue();
		ResultsDialogue resultsDialogue = new ResultsDialogue(guiCallBack);
		TurnDelayParameters turnDelayParameters = new TurnDelayParameters();
		CashOutDialogue cashOutDialogue = new CashOutDialogue(sm, guiCallBack);
		AddCreditsDialogue addCreditsDialogue = new AddCreditsDialogue(sm);
		PlaceBetDialogue placeBetDialogue = new PlaceBetDialogue(sm);

		MenuBar menuBar = new MenuBar(sm, registerDialogue, winningOddsDialogue, turnDelayParameters, cashOutDialogue,
				guiCallBack, resultsDialogue, addCreditsDialogue, placeBetDialogue);
		setJMenuBar(menuBar);

		GridBagConstraints toolBarConstraints = new GridBagConstraints();
		toolBarConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		toolBarConstraints.fill = GridBagConstraints.HORIZONTAL;
		toolBarConstraints.gridwidth = GridBagConstraints.REMAINDER;
		toolBarConstraints.gridx = 0;
		toolBarConstraints.gridy = 0;
		toolBarConstraints.ipady = 40;
		ToolBar toolBar = new ToolBar(sm, registerDialogue, winningOddsDialogue, resultsDialogue, turnDelayParameters,
				cashOutDialogue);
		add(toolBar, toolBarConstraints);

		GridBagConstraints playerPanelContraints = new GridBagConstraints();
		playerPanelContraints.anchor = GridBagConstraints.FIRST_LINE_START;
		playerPanelContraints.gridheight = GridBagConstraints.RELATIVE;
		playerPanelContraints.weightx = 0;
		playerPanelContraints.weighty = 0;
		playerPanelContraints.gridx = 0;
		playerPanelContraints.gridy = 1;
		PlayerPanel playerPanel = new PlayerPanel(sm, guiCallBack, addCreditsDialogue, placeBetDialogue,
				registerDialogue);
		add(playerPanel, playerPanelContraints);

		GridBagConstraints lineBetsPanelConstraints = new GridBagConstraints();
		lineBetsPanelConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		lineBetsPanelConstraints.gridwidth = GridBagConstraints.REMAINDER;
		lineBetsPanelConstraints.weightx = 0;
		lineBetsPanelConstraints.weighty = 1;
		lineBetsPanelConstraints.gridx = 0;
		lineBetsPanelConstraints.gridy = 2;
		LineBetsPanel lineBetsPanel = new LineBetsPanel(guiCallBack);
		add(lineBetsPanel, lineBetsPanelConstraints);

		GridBagConstraints statusBarConstraints = new GridBagConstraints();
		statusBarConstraints.anchor = GridBagConstraints.LAST_LINE_START;
		statusBarConstraints.fill = GridBagConstraints.HORIZONTAL;
		statusBarConstraints.gridwidth = GridBagConstraints.REMAINDER;
		statusBarConstraints.gridheight = 1;
		statusBarConstraints.weightx = 1;
		statusBarConstraints.weighty = GridBagConstraints.REMAINDER;
		;
		statusBarConstraints.gridx = 0;
		statusBarConstraints.gridy = 3;
		StatusBar statusBar = new StatusBar(guiCallBack);
		add(statusBar, statusBarConstraints);

		GridBagConstraints wheelsPanelConstraints = new GridBagConstraints();
		wheelsPanelConstraints.anchor = GridBagConstraints.FIRST_LINE_START;
		wheelsPanelConstraints.weightx = 0;
		wheelsPanelConstraints.weighty = 0;
		wheelsPanelConstraints.gridx = 1;
		wheelsPanelConstraints.gridy = 1;
		WheelsPanel wheelsPanel = new WheelsPanel(sm, guiCallBack);
		add(wheelsPanel, wheelsPanelConstraints);

		addComponentListener(new WheelPanelResizeListener(this, playerPanel, toolBar, statusBar, wheelsPanel));

	}

}