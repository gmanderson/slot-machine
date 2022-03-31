package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * The About dialogue box for <b>Slot Machine</b>.
 * <p>
 * This class constructs the About dialogue box called from the menu bar item.
 * </p>
 * 
 * @see slotmachine.view.MenuBar
 * 
 * @author Gerard Anderson CHANGE!!
 */

@SuppressWarnings("serial")
public class PreviousOutcomesDialogue extends JFrame implements PropertyChangeListener
{

	public PreviousOutcomesDialogue(GuiCallBack guiCallBack)
	{
		super("Previous Outcomes");

		guiCallBack.addPropertyChangeListener(this);

		setMinimumSize(new Dimension(300, 150));
		setResizable(false);
		setLocationRelativeTo(this);

		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 20;
		add(add(new JLabel("Not currently implemented")), gridBagConstraints);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{

		
	}
}
