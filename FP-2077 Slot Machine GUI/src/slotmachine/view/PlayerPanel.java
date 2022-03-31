package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import slotmachine.controller.OpenDialogueListener;
import slotmachine.controller.ResetBetsListener;
import slotmachine.model.SlotMachine;

/**
 * The Player Info Panel for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Player Info panel on the main window containing
 * information supplied when the player registers, as well as current betting
 * information.
 * </p>
 * <p>
 * Buttons for player functions adding credits and placing bets currently have
 * unimplemented functionality.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class PlayerPanel extends JPanel implements PropertyChangeListener
{
	private String playerID;
	private JLabel playerIDField;
	private String playerName;
	private JLabel playerNameField;
	private String initialCredits;
	private JLabel initialCreditsField;
	private String creditBalance;
	private JLabel creditBalanceField;
	private String bet;
	private JLabel betField;
	private JLabel playerIcon;
	private RegisterDialogue registerDialogue;

	public PlayerPanel(SlotMachine sm, GuiCallBack guiCallBack, AddCreditsDialogue addCreditsDialogue,
			PlaceBetDialogue placeBetDialogue, RegisterDialogue registerDialogue)
	{

		guiCallBack.addPropertyChangeListener(this);

		this.registerDialogue = registerDialogue;

		setPreferredSize(new Dimension(340, 290));
		setLayout(new GridBagLayout());

		GridBagConstraints gridBagContraints = new GridBagConstraints();

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 0;
		gridBagContraints.ipadx = 20;
		gridBagContraints.anchor = GridBagConstraints.WEST;
		add(add(new JLabel("Player Icon")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 0;
		gridBagContraints.ipadx = 20;
		playerIcon = new JLabel();
		playerIcon.setIcon(registerDialogue.getPlayerIcon());
		add(playerIcon);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 1;
		gridBagContraints.ipadx = 0;
		add(add(new JLabel("Player ID:")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 1;
		playerID = "REGISTER TO BEGIN";
		playerIDField = new JLabel(playerID);
		add(add(playerIDField), gridBagContraints);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 2;
		add(add(new JLabel("Player name:")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 2;
		playerName = "";
		playerNameField = new JLabel(playerName);
		add(add(playerNameField), gridBagContraints);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 3;
		add(add(new JLabel("Initial Credits:")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 3;
		initialCredits = "";
		initialCreditsField = new JLabel(initialCredits);
		add(add(initialCreditsField), gridBagContraints);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 4;
		add(add(new JLabel("Credit Balance:")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 4;
		creditBalance = "";
		creditBalanceField = new JLabel(creditBalance);
		add(add(creditBalanceField), gridBagContraints);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 5;
		add(add(new JLabel("Total Bets:")), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 5;
		bet = "";
		betField = new JLabel(bet);
		add(add(betField), gridBagContraints);

		gridBagContraints.gridx = 0;
		gridBagContraints.gridy = 6;
		gridBagContraints.fill = GridBagConstraints.HORIZONTAL;
		JButton addCredits = new JButton("Add Credits");
		add(add(addCredits), gridBagContraints);

		gridBagContraints.gridx = 1;
		gridBagContraints.gridy = 6;
		JButton placeBet = new JButton("Place Bet");
		add(add(placeBet), gridBagContraints);

		gridBagContraints.gridx = 3;
		gridBagContraints.gridy = 6;
		JButton resetBet = new JButton("Reset Bets");
		add(add(resetBet), gridBagContraints);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "PLAYER INFO"));

		addCredits.addActionListener(new OpenDialogueListener(addCreditsDialogue));

		placeBet.addActionListener(new OpenDialogueListener(placeBetDialogue));

		resetBet.addActionListener(new ResetBetsListener(sm));

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if (evt.getPropertyName() == "PLAYER_ID")
		{
			this.playerID = (String) evt.getNewValue();
			playerIDField.setText(this.playerID);
			playerIcon.setIcon(registerDialogue.getPlayerIcon());
		}

		if (evt.getPropertyName() == "PLAYER_NAME")
		{
			this.playerName = (String) evt.getNewValue();
			playerNameField.setText(this.playerName);
		}

		if (evt.getPropertyName() == "INITIAL_CREDITS")
		{
			this.initialCredits = (String) evt.getNewValue();
			initialCreditsField.setText(this.initialCredits);
		}

		if (evt.getPropertyName() == "CREDIT_BALANCE")
		{
			this.creditBalance = (String) evt.getNewValue();
			creditBalanceField.setText(this.creditBalance);
		}

		if (evt.getPropertyName() == "BET")
		{
			this.bet = (String) evt.getNewValue();
			betField.setText(this.bet);
		}

		if (evt.getPropertyName() == "AMOUNT")
		{
			this.bet = (String) evt.getNewValue();
			betField.setText(this.bet);
		}

	}

}
