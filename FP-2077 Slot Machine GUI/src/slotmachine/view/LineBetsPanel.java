package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Line Bets Panel for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Line Bets panel on the main window containing
 * information indicating bets placed. This information will be supplied by the
 * player.
 * </p>
 * <p>
 * Functionality is currently unimplemented.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class LineBetsPanel extends JPanel implements PropertyChangeListener
{
	private String line1bet;
	private JLabel line1Field;
	private String line2bet;
	private JLabel line2Field;
	private String line3bet;
	private JLabel line3Field;
	private String line4bet;
	private JLabel line4Field;
	private String line5bet;
	private JLabel line5Field;

	public LineBetsPanel(GuiCallBack gcb)
	{
		gcb.addPropertyChangeListener(this);
		
		setPreferredSize(new Dimension(340, 200));
		this.setLayout(new GridLayout(5, 2));

		add(new JLabel("LINE 1:"));
		line1bet = "NO BET";
		line1Field = new JLabel(line1bet);
		add(line1Field);

		add(new JLabel("LINE 2:"));
		line2bet = "NO BET";
		line2Field = new JLabel(line2bet);
		add(line2Field);
		
		add(new JLabel("LINE 3:"));
		line3bet = "NO BET";
		line3Field = new JLabel(line3bet);
		add(line3Field);
		
		add(new JLabel("LINE 4:"));
		line4bet = "NO BET";
		line4Field = new JLabel(line4bet);
		add(line4Field);
		
		add(new JLabel("LINE 5:"));
		line5bet = "NO BET";
		line5Field = new JLabel(line5bet);
		add(line5Field);

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createRaisedBevelBorder(), "LINE BETS"));

	}
	
	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if(evt.getPropertyName() == "LINE1")
		{
			this.line1bet = (String) evt.getNewValue();
			line1Field.setText(this.line1bet);
		}
		
		if(evt.getPropertyName() == "LINE2")
		{
			this.line2bet = (String) evt.getNewValue();
			line2Field.setText(this.line2bet);
		}
		
		if(evt.getPropertyName() == "LINE3")
		{
			this.line3bet = (String) evt.getNewValue();
			line3Field.setText(this.line3bet);
		}
		
		if(evt.getPropertyName() == "LINE4")
		{
			this.line4bet = (String) evt.getNewValue();
			line4Field.setText(this.line4bet);
		}
		
		if(evt.getPropertyName() == "LINE5")
		{
			this.line5bet = (String) evt.getNewValue();
			line5Field.setText(this.line5bet);
		}
		
	}
}
