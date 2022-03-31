package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

/**
 * The Status Bar for <b>Slot Machine</b>.
 * <p>
 * This class constructs the status bar on the main window. The status bar
 * provides status of a recently performed function (player registered, bets
 * placed, etc) and status of wheels (ready, spinning, etc.)
 * </p>
 * <p>
 * Functionality currently unimplemented.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class StatusBar extends JPanel implements PropertyChangeListener
{
	private JLabel functionStatus;
	private JLabel wheelStatus;
	private String wheelStatusText;
	private String functionStatusText;

	public StatusBar(GuiCallBack guiCallBack)
	{

		guiCallBack.addPropertyChangeListener(this);

		setLayout(new GridLayout());

		setPreferredSize(new Dimension(20, 45));

		Border border = BorderFactory.createLoweredBevelBorder();

		functionStatusText = "";
		functionStatus = new JLabel(functionStatusText, SwingConstants.CENTER);
		functionStatus.setBorder(border);
		add(functionStatus);

		wheelStatusText = "REGISTER PLAYER";
		wheelStatus = new JLabel(wheelStatusText, SwingConstants.CENTER);
		wheelStatus.setBorder(border);

		add(wheelStatus);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if (evt.getPropertyName() == "SPINNING")
		{
			wheelStatusText = (String) evt.getNewValue();
			wheelStatus.setText(wheelStatusText);
		}

		if (evt.getPropertyName() == "READY")
		{
			wheelStatusText = (String) evt.getNewValue();
			wheelStatus.setText(wheelStatusText);
		}

		if (evt.getPropertyName() == "BET_UPDATED")
		{
			functionStatusText = (String) evt.getNewValue();
			functionStatus.setText(functionStatusText);
		}

		if (evt.getPropertyName() == "PLAYER_REGISTERED")
		{
			functionStatusText = (String) evt.getNewValue();
			functionStatus.setText(functionStatusText);
		}

		if (evt.getPropertyName() == "PLACE_BET")
		{
			wheelStatusText = (String) evt.getNewValue();
			wheelStatus.setText(wheelStatusText);
		}

		if (evt.getPropertyName() == "CASHED_OUT")
		{
			functionStatusText = (String) evt.getNewValue();
			functionStatus.setText(functionStatusText);
		}

		if (evt.getPropertyName() == "REGISTER_PLAYER")
		{
			wheelStatusText = (String) evt.getNewValue();
			wheelStatus.setText(wheelStatusText);
		}

		if (evt.getPropertyName() == "CREDITS_ADDED")
		{
			functionStatusText = (String) evt.getNewValue();
			functionStatus.setText(functionStatusText);
		}

	}
}
