package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * The About dialogue box for <b>Slot Machine</b>.
 * <p>
 * This class constructs the About dialogue box called from the menu bar item.
 * </p>
 * 
 * @see slotmachine.view.MenuBar
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class AboutDialogue extends JFrame
{
	public AboutDialogue()
	{
		super("About Slot Machine");

		setMinimumSize(new Dimension(300, 370));
		setResizable(false);
		setLocationRelativeTo(this);
		setLayout(new GridLayout(16, 1));

		add(new JLabel("You are enjoying Slot Machine by", SwingConstants.CENTER));
		add(new JLabel("Gerard Anderson", SwingConstants.CENTER));
		add(new JLabel("RMIT ID s3318814", SwingConstants.CENTER));
		add(new JLabel(""));
		add(new JLabel("With partial model code supplied by", SwingConstants.CENTER));
		add(new JLabel("Ross Nye", SwingConstants.CENTER));
		add(new JLabel(""));
		add(new JLabel("Icons made by", SwingConstants.CENTER));
		add(new JLabel("Cherry: mynamepong", SwingConstants.CENTER));
		add(new JLabel("Lemon, Strawberry, Lime, Berry, 5, 3, 1,", SwingConstants.CENTER));
		add(new JLabel("Hacker, Clown, Monster, Astronaut: Freepik", SwingConstants.CENTER));
		add(new JLabel("Melon, Gold: Smashicons", SwingConstants.CENTER));
		add(new JLabel("7: fjstudio", SwingConstants.CENTER));
		add(new JLabel("All sourced from www.flaticon.com except", SwingConstants.CENTER));
		add(new JLabel("Silver sourced from www.hiclipart.com", SwingConstants.CENTER));

		JButton close = new JButton("Close");
		close.setMnemonic(KeyEvent.VK_ESCAPE);
		add(close);

		close.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				dispose();
			}
		});

	}
}
