package slotmachine.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import slotmachine.model.SlotIcons;

/**
 * The Winning Odds Dialogue box for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Winning Odds dialogue box called from the menu bar
 * item.
 * </p>
 * 
 * @see slotmachine.view.MenuBar
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class WinningOddsDialogue extends JFrame
{
	public WinningOddsDialogue()
	{
		super("Winning Odds Information");

		setMinimumSize(new Dimension(400, 900));
		setResizable(false);
		setLocationRelativeTo(this);
		setLayout(new FlowLayout());

		ImageIcon gold = SlotIcons.GOLD.getIcon();
		ImageIcon silver = SlotIcons.SILVER.getIcon();
		ImageIcon melon = SlotIcons.MELON.getIcon();
		ImageIcon seven = SlotIcons.SEVEN.getIcon();
		ImageIcon cherry = SlotIcons.CHERRY.getIcon();
		ImageIcon berry = SlotIcons.BERRY.getIcon();

		add(new JLabel(gold));
		add(new JLabel(gold));
		add(new JLabel(gold));
		add(new JLabel("Wins 50"));

		add(new JLabel(silver));
		add(new JLabel(silver));
		add(new JLabel(silver));
		add(new JLabel("Wins 33"));

		add(new JLabel(gold));
		add(new JLabel(gold));
		add(new JLabel(silver));
		add(new JLabel("Wins 27"));

		add(new JLabel(gold));
		add(new JLabel(silver));
		add(new JLabel(silver));
		add(new JLabel("Wins 22"));

		add(new JLabel(melon));
		add(new JLabel(melon));
		add(new JLabel(melon));
		add(new JLabel("Wins 18"));

		add(new JLabel(gold));
		add(new JLabel(gold));
		add(new JLabel(seven));
		add(new JLabel("Wins 17"));

		add(new JLabel(cherry));
		add(new JLabel(cherry));
		add(new JLabel(cherry));
		add(new JLabel("Wins 16"));

		add(new JLabel(berry));
		add(new JLabel(berry));
		add(new JLabel(berry));
		add(new JLabel("Wins 14"));

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
