package slotmachine.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import slotmachine.controller.PlaceBetsListener;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class PlaceBetDialogue extends JFrame
{
	private JTextField betAmount;
	private JCheckBox line1CheckBox;
	private JCheckBox line2CheckBox;
	private JCheckBox line3CheckBox;
	private JCheckBox line4CheckBox;
	private JCheckBox line5CheckBox;

	public PlaceBetDialogue(SlotMachine sm)
	{
		super("Place Bets");

		setResizable(false);
		setLayout(new GridLayout(6, 1));

		add(new JLabel("Bet amount"));
		betAmount = new JTextField();
		add(betAmount);

		line1CheckBox = new JCheckBox("Line 1");
		add(line1CheckBox);

		line2CheckBox = new JCheckBox("Line 2");
		add(line2CheckBox);

		line3CheckBox = new JCheckBox("Line 3");
		add(line3CheckBox);

		line4CheckBox = new JCheckBox("Line 4");
		add(line4CheckBox);

		line5CheckBox = new JCheckBox("Line 5");
		add(line5CheckBox);

		add(new JLabel(""));
		JButton cancel = new JButton("Cancel");
		cancel.setMnemonic(KeyEvent.VK_ESCAPE);
		add(cancel);

		JButton placeBets = new JButton("Place Bets");
		placeBets.setMnemonic(KeyEvent.VK_P);
		add(placeBets);

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

		placeBets.addActionListener(new PlaceBetsListener(this, sm));

	}

	public JTextField getBetAmount()
	{

		return betAmount;

	}

	public boolean getLine1State()
	{

		return line1CheckBox.isSelected();

	}

	public boolean getLine2State()
	{

		return line2CheckBox.isSelected();

	}

	public boolean getLine3State()
	{

		return line3CheckBox.isSelected();

	}

	public boolean getLine4State()
	{

		return line4CheckBox.isSelected();

	}

	public boolean getLine5State()
	{

		return line5CheckBox.isSelected();

	}

	public void resetFields()
	{
		this.betAmount.setText("");
		this.line1CheckBox.setSelected(false);
		this.line2CheckBox.setSelected(false);
		this.line3CheckBox.setSelected(false);
		this.line4CheckBox.setSelected(false);
		this.line5CheckBox.setSelected(false);
	}

}
