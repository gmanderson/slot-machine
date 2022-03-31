package slotmachine.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import slotmachine.controller.AddCreditsListener;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class AddCreditsDialogue extends JFrame
{

	private JTextField numberCredits;

	public AddCreditsDialogue(SlotMachine sm)
	{
		super("Add Credits");

		setResizable(false);
		setLayout(new GridLayout(4, 2));

		add(new JLabel("Number of credits"));
		numberCredits = new JTextField();
		add(numberCredits);

		JButton cancel = new JButton("Cancel");
		cancel.setMnemonic(KeyEvent.VK_ESCAPE);
		add(cancel);

		JButton addCredits = new JButton("Add Credits");
		addCredits.setMnemonic(KeyEvent.VK_C);
		add(addCredits);

		pack();

		// Centres dialogue box
		setLocationRelativeTo(null);

		addCredits.addActionListener(new AddCreditsListener(this, sm));

		cancel.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				resetFields();
				dispose();
			}
		});

	}

	public JTextField getNumCreditsField()
	{
		return numberCredits;
	}

	public void resetFields()
	{
		this.numberCredits.setText("");

	}

}
