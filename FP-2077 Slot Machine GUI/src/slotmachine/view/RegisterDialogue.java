package slotmachine.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import slotmachine.controller.PlayerIconListener;
import slotmachine.controller.RegisterPlayerListener;
import slotmachine.model.PlayerIcons;
import slotmachine.model.SlotMachine;

/**
 * The Register dialogue box for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Register Player dialogue box called from the menu
 * bar item. Text fields will allow capture of player information that will be
 * sent to the model.
 * </p>
 * 
 * @see slotmachine.view.MenuBar
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class RegisterDialogue extends JFrame
{
	private JTextField playerIDField;
	private JTextField playerNameField;
	private JTextField initialCreditsField;
	private ImageIcon playerIcon;

	public RegisterDialogue(SlotMachine sm)
	{
		super("Register Player");

		setResizable(false);
		setLocationRelativeTo(null);

		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;

		add(add(new JLabel("Choose an avatar")), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;

		add(add(new JLabel(PlayerIcons.ASTRONAUT.getIcon())), gridBagConstraints);
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 1;

		add(add(new JLabel(PlayerIcons.CLOWN.getIcon())), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;

		add(add(new JLabel(PlayerIcons.HACKER.getIcon())), gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;

		add(add(new JLabel(PlayerIcons.MONSTER.getIcon())), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		JRadioButton astronaut = new JRadioButton(PlayerIcons.ASTRONAUT.getLabel());
		add(add(astronaut), gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		JRadioButton clown = new JRadioButton(PlayerIcons.CLOWN.getLabel());
		add(add(clown), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		JRadioButton hacker = new JRadioButton(PlayerIcons.HACKER.getLabel());
		add(add(hacker), gridBagConstraints);

		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		JRadioButton monster = new JRadioButton(PlayerIcons.MONSTER.getLabel());
		add(add(monster), gridBagConstraints);

		ButtonGroup avatars = new ButtonGroup();
		avatars.add(astronaut);
		avatars.add(clown);
		avatars.add(hacker);
		avatars.add(monster);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.anchor = GridBagConstraints.LINE_START;
		add(add(new JLabel("Player ID")), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		playerIDField = new JTextField(15);
		add(add(playerIDField), gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		add(add(new JLabel("Player Name")), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		playerNameField = new JTextField(15);
		add(add(playerNameField), gridBagConstraints);

		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 5;
		add(add(new JLabel("Initial Credits")), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 5;
		initialCreditsField = new JTextField(15);
		add(add(initialCreditsField), gridBagConstraints);

		gridBagConstraints.anchor = GridBagConstraints.CENTER;
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 6;
		JButton cancel = new JButton("Cancel");
		cancel.setMnemonic(KeyEvent.VK_ESCAPE);
		add(add(cancel), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 6;
		JButton register = new JButton("Register");
		register.setMnemonic(KeyEvent.VK_R);
		add(add(register), gridBagConstraints);

		pack();

		// Centres dialogue box
		setLocationRelativeTo(null);

		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				resetFields();
				dispose();
			}
		});

		register.addActionListener(new RegisterPlayerListener(this, sm));

		astronaut.addActionListener(new PlayerIconListener(this));
		astronaut.doClick();
		clown.addActionListener(new PlayerIconListener(this));
		hacker.addActionListener(new PlayerIconListener(this));
		monster.addActionListener(new PlayerIconListener(this));

	}

	public JTextField getPlayerIDField()
	{
		return playerIDField;
	}

	public JTextField getPlayerNameField()
	{
		return playerNameField;
	}

	public JTextField getInitialCreditsField()
	{
		return initialCreditsField;
	}

	public void setPlayerIcon(String name)
	{
		if (name == PlayerIcons.ASTRONAUT.getLabel())
		{
			playerIcon = PlayerIcons.ASTRONAUT.getIcon();
		}

		if (name == PlayerIcons.CLOWN.getLabel())
		{
			playerIcon = PlayerIcons.CLOWN.getIcon();
		}

		if (name == PlayerIcons.HACKER.getLabel())
		{
			playerIcon = PlayerIcons.HACKER.getIcon();
		}

		if (name == PlayerIcons.MONSTER.getLabel())
		{
			playerIcon = PlayerIcons.MONSTER.getIcon();
		}
	}

	public ImageIcon getPlayerIcon()
	{
		return this.playerIcon;
	}

	public void resetFields()
	{
		this.playerIDField.setText("");
		this.playerNameField.setText("");
		this.initialCreditsField.setText("");
	}

}
