package slotmachine.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import slotmachine.controller.CashOutListener;
import slotmachine.model.SlotMachine;

@SuppressWarnings("serial")
public class CashOutDialogue extends JFrame implements PropertyChangeListener
{

	private JLabel numberCredits;
	
	public CashOutDialogue(SlotMachine sm, GuiCallBack guiCallBack)
	{
		super("Cash Out");

		guiCallBack.addPropertyChangeListener(this);
		
		setResizable(false);
		
		setLayout(new GridLayout(4, 4));

		add(new JLabel("Are you sure you want to cash out?"));
		add(new JLabel(""));
		add(new JLabel("Number of credits cashing out"));
		numberCredits = new JLabel("");
		add(numberCredits);

		JButton no = new JButton("No");
		no.setMnemonic(KeyEvent.VK_ESCAPE);
		add(no);

		JButton yes = new JButton("Yes");
		yes.setMnemonic(KeyEvent.VK_Y);
		add(yes);

		pack();

		// Centres dialogue box
		setLocationRelativeTo(null);
		
		yes.addActionListener(new CashOutListener(this, sm));

		no.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

	}

	public void resetCredits() {
		numberCredits.setText("");
	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if(evt.getPropertyName() == "CREDITS_TO_CASHOUT")
		{
			numberCredits.setText((String) evt.getNewValue());
		}
		
	}

}
