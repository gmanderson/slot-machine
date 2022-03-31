package slotmachine.view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Collection;
import javax.swing.SwingUtilities;
import slotmachine.model.Player;
import slotmachine.model.slots.LineNum;
import slotmachine.model.slots.SlotLine;
import slotmachine.model.slots.SpinResult;
import slotmachine.model.slots.Wheel;

public class GuiCallBack implements GameCallback
{

	private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

	@Override
	public void registerPlayer(Player player)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				pcs.firePropertyChange("PLAYER_ID", null, player.getId());
				pcs.firePropertyChange("PLAYER_NAME", null, player.getName());
				pcs.firePropertyChange("INITIAL_CREDITS", null, Integer.toString(player.getInitalCredits()));
				pcs.firePropertyChange("CREDIT_BALANCE", null, Integer.toString(player.getAvailableCredits()));
				pcs.firePropertyChange("BET", null, Integer.toString(player.getBet()));
				pcs.firePropertyChange("CREDITS_TO_CASHOUT", null, Integer.toString(player.getCredits()));
				pcs.firePropertyChange("PLAYER_REGISTERED", null, "Player Registered");
				pcs.firePropertyChange("PLACE_BET", null, "Place Bet to Spin");
			}
		});
	}

	@Override
	public void cashOutPlayer(Player player)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				pcs.firePropertyChange("PLAYER_ID", null, "REGISTER TO PLAY");
				pcs.firePropertyChange("PLAYER_NAME", null, "");
				pcs.firePropertyChange("INITIAL_CREDITS", null, "");
				pcs.firePropertyChange("CREDIT_BALANCE", null, "");
				pcs.firePropertyChange("BET", null, "");
				pcs.firePropertyChange("REGISTER_PLAYER", null, "REGISTER PLAYER");
				pcs.firePropertyChange("CASHED_OUT", null, "Player Cashed Out");
			}
		});
	}

	@Override
	public void addCredits(Player player, int credits)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				pcs.firePropertyChange("CREDIT_BALANCE", null, Integer.toString(player.getAvailableCredits()));
				pcs.firePropertyChange("CREDITS_ADDED", null, "Credits Added");
			}
		});
	}

	@Override
	public void betUpdated(Player player, int amount, LineNum line)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				String amountText;
				if (amount > 0)
				{
					amountText = Integer.toString(amount);
				} else
				{
					amountText = "NO BET";
				}

				if (line == LineNum.LINE1)
				{
					pcs.firePropertyChange("LINE1", null, amountText);
				}
				if (line == LineNum.LINE2)
				{
					pcs.firePropertyChange("LINE2", null, amountText);
				}
				if (line == LineNum.LINE3)
				{
					pcs.firePropertyChange("LINE3", null, amountText);
				}
				if (line == LineNum.LINE4)
				{
					pcs.firePropertyChange("LINE4", null, amountText);
				}
				if (line == LineNum.LINE5)
				{
					pcs.firePropertyChange("LINE5", null, amountText);
				}
				pcs.firePropertyChange("CREDIT_BALANCE", null, Integer.toString(player.getAvailableCredits()));
				pcs.firePropertyChange("BET", null, Integer.toString(player.getBet()));

				pcs.firePropertyChange("BET_UPDATED", null, "Bets Updated");
				pcs.firePropertyChange("READY", null, "Ready to Spin!");

			}
		});

	}

	@Override
	public void betUpdated(Player player, int amount, Collection<LineNum> lines)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				for (LineNum ln : lines)
				{
					betUpdated(player, amount, ln); // Refers back to previous method
				}
			}
		});

	}

	@Override
	public void turnWheel(Wheel wheel, int turnNum)
	{

		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				String spinning = "SPINNING!";
				pcs.firePropertyChange("SPINNING", null, spinning);

				if (wheel.toString().contains("Wheel #1"))
				{
					pcs.firePropertyChange("WHEEL1TOP", null, wheel.getTopSlot());
					pcs.firePropertyChange("WHEEL1CENTRE", null, wheel.getCentreSlot());
					pcs.firePropertyChange("WHEEL1BOTTOM", null, wheel.getBottomSlot());
				}

				if (wheel.toString().contains("Wheel #2"))
				{
					pcs.firePropertyChange("WHEEL2TOP", null, wheel.getTopSlot());
					pcs.firePropertyChange("WHEEL2CENTRE", null, wheel.getCentreSlot());
					pcs.firePropertyChange("WHEEL2BOTTOM", null, wheel.getBottomSlot());
				}

				if (wheel.toString().contains("Wheel #3"))
				{
					pcs.firePropertyChange("WHEEL3TOP", null, wheel.getTopSlot());
					pcs.firePropertyChange("WHEEL3CENTRE", null, wheel.getCentreSlot());
					pcs.firePropertyChange("WHEEL3BOTTOM", null, wheel.getBottomSlot());
				}
			}
		});

	}

	@Override
	public void spinComplete(SpinResult spinResult)
	{
		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				String ready = "Ready to Spin!";
				pcs.firePropertyChange("READY", null, ready);
			}
		});

	}

	@Override
	public void lineResult(Player player, boolean hasBet, int lineOutcome, SlotLine slotLine)
	{

		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{

				String winLose;

				if (hasBet)
				{
					winLose = ((lineOutcome > 0) ? String.format("WIN ", lineOutcome) : "LOSS");

					pcs.firePropertyChange("HAS_BET", null, hasBet);

					if (slotLine.getLineNum() == LineNum.LINE1)
					{

						pcs.firePropertyChange("OUTCOME1", null, Integer.toString(lineOutcome));
						pcs.firePropertyChange("SLOTLINE1", null, slotLine.getLineNum().toString());
						pcs.firePropertyChange("WINLOSE1", null, winLose);
						pcs.firePropertyChange("LINE1SLOTS", null, slotLine);
					}

					if (slotLine.getLineNum() == LineNum.LINE2)
					{
						pcs.firePropertyChange("OUTCOME2", null, Integer.toString(lineOutcome));
						pcs.firePropertyChange("SLOTLINE2", null, slotLine.getLineNum().toString());
						pcs.firePropertyChange("WINLOSE2", null, winLose);
					}

					if (slotLine.getLineNum() == LineNum.LINE3)
					{

						pcs.firePropertyChange("OUTCOME3", null, Integer.toString(lineOutcome));
						pcs.firePropertyChange("SLOTLINE3", null, slotLine.getLineNum().toString());
						pcs.firePropertyChange("WINLOSE3", null, winLose);
					}

					if (slotLine.getLineNum() == LineNum.LINE4)
					{

						pcs.firePropertyChange("OUTCOME4", null, Integer.toString(lineOutcome));
						pcs.firePropertyChange("SLOTLINE4", null, slotLine.getLineNum().toString());
						pcs.firePropertyChange("WINLOSE4", null, winLose);
					}

					if (slotLine.getLineNum() == LineNum.LINE5)
					{

						pcs.firePropertyChange("OUTCOME5", null, Integer.toString(lineOutcome));
						pcs.firePropertyChange("SLOTLINE5", null, slotLine.getLineNum().toString());
						pcs.firePropertyChange("WINLOSE5", null, winLose);
					}
				}

			}
		});
	}

	@Override
	public void betTotals(Player player, int total)
	{

		SwingUtilities.invokeLater(new Runnable()
		{

			@Override
			public void run()
			{
				pcs.firePropertyChange("CREDIT_BALANCE", null, Integer.toString(player.getAvailableCredits()));
				pcs.firePropertyChange("CREDITS_TO_CASHOUT", null, Integer.toString(player.getCredits()));

			}
		});

	}

	public void addPropertyChangeListener(PropertyChangeListener listener)
	{
		this.pcs.addPropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener)
	{
		this.pcs.removePropertyChangeListener(listener);
	}
}
