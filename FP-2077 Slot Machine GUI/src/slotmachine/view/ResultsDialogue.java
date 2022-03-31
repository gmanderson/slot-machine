package slotmachine.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ResultsDialogue extends JFrame implements PropertyChangeListener
{

	private String lineOutcomeText1;
	private JLabel lineOutcomeLabel1;
	private String slotLineText1;
	private JLabel slotLineLabel1;
	private String winLoseText1;
	private JLabel winLoseLabel1;

	private JLabel slotLineLabel2;
	private JLabel lineOutcomeLabel2;
	private JLabel winLoseLabel2;
	private String lineOutcomeText2;
	private String slotLineText2;
	private String winLoseText2;

	private JLabel slotLineLabel3;
	private JLabel lineOutcomeLabel3;
	private JLabel winLoseLabel3;
	private String lineOutcomeText3;
	private String slotLineText3;
	private String winLoseText3;

	private JLabel slotLineLabel4;
	private JLabel lineOutcomeLabel4;
	private JLabel winLoseLabel4;
	private String lineOutcomeText4;
	private String slotLineText4;
	private String winLoseText4;

	private JLabel slotLineLabel5;
	private JLabel lineOutcomeLabel5;
	private JLabel winLoseLabel5;
	private String lineOutcomeText5;
	private String slotLineText5;
	private String winLoseText5;

	public ResultsDialogue(GuiCallBack guiCallBack)
	{
		super("Results");

		guiCallBack.addPropertyChangeListener(this);

		setMinimumSize(new Dimension(300, 150));
		setResizable(false);
		setLocationRelativeTo(this);

		setLayout(new GridBagLayout());

		GridBagConstraints gridBagConstraints = new GridBagConstraints();

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 20;
		slotLineLabel1 = new JLabel(slotLineText1);
		add(add(slotLineLabel1), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 20;
		lineOutcomeLabel1 = new JLabel(lineOutcomeText1);
		add(add(lineOutcomeLabel1), gridBagConstraints);

		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.ipadx = 20;
		winLoseLabel1 = new JLabel(winLoseText1);
		add(add(winLoseLabel1), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		slotLineLabel2 = new JLabel("");
		add(add(slotLineLabel2), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 1;
		lineOutcomeLabel2 = new JLabel("");
		add(add(lineOutcomeLabel2), gridBagConstraints);

		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 1;
		winLoseLabel2 = new JLabel("");
		add(add(winLoseLabel2), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		slotLineLabel3 = new JLabel("");
		add(add(slotLineLabel3), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 2;
		lineOutcomeLabel3 = new JLabel("");
		add(add(lineOutcomeLabel3), gridBagConstraints);

		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 2;
		winLoseLabel3 = new JLabel("");
		add(add(winLoseLabel3), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 3;
		slotLineLabel4 = new JLabel("");
		add(add(slotLineLabel4), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 3;
		lineOutcomeLabel4 = new JLabel("");
		add(add(lineOutcomeLabel4), gridBagConstraints);

		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 3;
		winLoseLabel4 = new JLabel("");
		add(add(winLoseLabel4), gridBagConstraints);

		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		slotLineLabel5 = new JLabel("");
		add(add(slotLineLabel5), gridBagConstraints);

		gridBagConstraints.gridx = 2;
		gridBagConstraints.gridy = 4;
		lineOutcomeLabel5 = new JLabel("");
		add(add(lineOutcomeLabel5), gridBagConstraints);

		gridBagConstraints.gridx = 4;
		gridBagConstraints.gridy = 4;
		winLoseLabel5 = new JLabel("");
		add(add(winLoseLabel5), gridBagConstraints);

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{
		if (evt.getPropertyName() == "HAS_BET")
		{
			setVisible(true);
		}
		if (evt.getPropertyName() == "OUTCOME1")
		{
			lineOutcomeText1 = (String) evt.getNewValue();
			lineOutcomeLabel1.setText(this.lineOutcomeText1);
		}

		if (evt.getPropertyName() == "SLOTLINE1")
		{
			slotLineText1 = (String) evt.getNewValue();
			slotLineLabel1.setText(this.slotLineText1);
		}

		if (evt.getPropertyName() == "WINLOSE1")
		{
			winLoseText1 = (String) evt.getNewValue();
			winLoseLabel1.setText(this.winLoseText1);
		}

		if (evt.getPropertyName() == "OUTCOME2")
		{
			lineOutcomeText2 = (String) evt.getNewValue();
			lineOutcomeLabel2.setText(this.lineOutcomeText2);
		}

		if (evt.getPropertyName() == "SLOTLINE2")
		{
			slotLineText2 = (String) evt.getNewValue();
			slotLineLabel2.setText(this.slotLineText2);
		}

		if (evt.getPropertyName() == "WINLOSE2")
		{
			winLoseText2 = (String) evt.getNewValue();
			winLoseLabel2.setText(this.winLoseText2);
		}

		if (evt.getPropertyName() == "OUTCOME3")
		{
			lineOutcomeText3 = (String) evt.getNewValue();
			lineOutcomeLabel3.setText(this.lineOutcomeText3);
		}

		if (evt.getPropertyName() == "SLOTLINE3")
		{
			slotLineText3 = (String) evt.getNewValue();
			slotLineLabel3.setText(this.slotLineText3);
		}

		if (evt.getPropertyName() == "WINLOSE3")
		{
			winLoseText3 = (String) evt.getNewValue();
			winLoseLabel3.setText(this.winLoseText3);
		}

		if (evt.getPropertyName() == "OUTCOME4")
		{
			lineOutcomeText4 = (String) evt.getNewValue();
			lineOutcomeLabel4.setText(this.lineOutcomeText4);
		}

		if (evt.getPropertyName() == "SLOTLINE4")
		{
			slotLineText4 = (String) evt.getNewValue();
			slotLineLabel4.setText(this.slotLineText4);
		}

		if (evt.getPropertyName() == "WINLOSE4")
		{
			winLoseText4 = (String) evt.getNewValue();
			winLoseLabel4.setText(this.winLoseText4);
		}

		if (evt.getPropertyName() == "OUTCOME5")
		{
			lineOutcomeText5 = (String) evt.getNewValue();
			lineOutcomeLabel5.setText(this.lineOutcomeText5);
		}

		if (evt.getPropertyName() == "SLOTLINE5")
		{
			slotLineText5 = (String) evt.getNewValue();
			slotLineLabel5.setText(this.slotLineText5);
		}

		if (evt.getPropertyName() == "WINLOSE5")
		{
			winLoseText5 = (String) evt.getNewValue();
			winLoseLabel5.setText(this.winLoseText5);
		}

	}
}
