package slotmachine.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import slotmachine.model.slots.LineNum;
import slotmachine.model.slots.SlotLine;
import slotmachine.model.slots.SpinResult;
import slotmachine.model.slots.SpinResultImpl;
import slotmachine.model.slots.Wheel;
import slotmachine.model.slots.WheelImpl;
import slotmachine.model.slots.WinSettings;
import slotmachine.model.slots.WinSettingsImpl;
import slotmachine.view.GameCallback;
import slotmachine.view.GameCallbackCollection;

public class SlotMachineImpl implements SlotMachine, GameCallbackCollection
{
	private Wheel wheel1;
	private Wheel wheel2;
	private Wheel wheel3;
	private Player player;
	private ArrayList<GameCallback> gameCallbackArrayList;
	private WinSettings winSettings;
	private final double WHEEL_2_PERCENTAGE = .66;
	private final double WHEEL_3_PERCENTAGE = .33;
	private Map<LineNum, Integer> linesBet;

	public SlotMachineImpl()
	{
		gameCallbackArrayList = new ArrayList<GameCallback>();
		this.wheel1 = WheelImpl.createWheel(1);
		this.wheel2 = WheelImpl.createWheel(2);
		this.wheel3 = WheelImpl.createWheel(3);
		this.winSettings = new WinSettingsImpl();
		linesBet = new HashMap<LineNum, Integer>();
	}

	public SlotMachineImpl(Wheel wheel1, Wheel wheel2, Wheel wheel3, WinSettings winSettings)
	{
		gameCallbackArrayList = new ArrayList<GameCallback>();
		this.wheel1 = wheel1;
		this.wheel2 = wheel2;
		this.wheel3 = wheel3;
		this.winSettings = winSettings;
		linesBet = new HashMap<LineNum, Integer>();
	}

	@Override
	public int addCallback(GameCallback callback)
	{
		this.gameCallbackArrayList.add(callback);
		return this.gameCallbackArrayList.size();

	}

	@Override
	public int removeCallback(GameCallback callback)
	{

		this.gameCallbackArrayList.remove(callback);
		return this.gameCallbackArrayList.size();
		
	}

	@Override
	public Player registerPlayer(String id, String name, int initialCredits)
	{
		if (id.equals(null) || id.isEmpty())
			throw new IllegalArgumentException("Player id may not be empty");

		if (name.equals(null) || name.isEmpty())
			throw new IllegalArgumentException("Player name may not be empty");

		if (initialCredits < 0)
			throw new IllegalArgumentException("Initial credits are invalid. Must be greater than 0.");

		if (id.length()!=6)
			throw new IllegalArgumentException("Player id must be 5 number followed by 1 letter");
		
		for (int i = 0; i < 5; i++)
		{
			if (!Character.isDigit(id.charAt(i)))
				throw new IllegalArgumentException("Player id must be 5 number followed by 1 letter");
		}

		if (!Character.isLetter(id.charAt(5)))
			throw new IllegalArgumentException("Player id must be 5 number followed by 1 letter");

		player = new PlayerImpl(id, name, initialCredits);

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.registerPlayer(player);
		}

		return player;
	}

	@Override
	public Player cashOut()
	{
		if (player == null)
			throw new IllegalStateException(String.format("No registered player"));

		resetBets();

		Player removedPlayer = player;
		player = null;

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.cashOutPlayer(removedPlayer);
		}
		return removedPlayer;
	}

	@Override
	public void addCredits(int credits) throws IllegalStateException, IllegalArgumentException
	{
		if (player == null)
			throw new IllegalStateException(String.format("No registered player."));

		if (credits <= 0)
			throw new IllegalArgumentException(String.format("Added credits must be greater than 0."));

		player.addCredits(credits);

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.addCredits(player, credits);
		}

	}

	@Override
	public void placeBet(int amount) throws IllegalArgumentException, IllegalStateException
	{
		this.placeBet(amount, LineNum.LINE1);
	}

	@Override
	public void placeBet(int amount, LineNum line) throws IllegalArgumentException, IllegalStateException
	{
		if (player == null)
			throw new IllegalStateException(String.format("No registered player."));

		if (amount <= 0)
			throw new IllegalArgumentException(String.format("Bet must be greater than 0."));

		if (player.getAvailableCredits() < amount)
			throw new IllegalArgumentException(String.format("Not enough credits to place bet."));

		if ((linesBet.get(line) != null) && (linesBet.get(line) >= amount))
			throw new IllegalArgumentException(String.format("Greater value bet already placed for %s.", line));

		if (line == null)
			throw new IllegalArgumentException(String.format("No line number supplied"));

		linesBet.put(line, amount);

		int totalAmount = 0;
		for (LineNum ln : linesBet.keySet())
		{
			totalAmount += linesBet.get(ln);
		}

		player.setBet(totalAmount);

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.betUpdated(player, amount, line);
		}
	}

	@Override
	public void placeBet(int amount, Set<LineNum> lines) throws IllegalArgumentException, IllegalStateException
	{
		if (player == null)
			throw new IllegalStateException(String.format("No registered player."));

		if (amount <= 0)
			throw new IllegalArgumentException(String.format("Bet must be greater than 0."));

		int totalAmount = 0;
		for (LineNum ln : lines)
		{
			if ((linesBet.get(ln) != null) && (linesBet.get(ln) >= amount))
				throw new IllegalArgumentException(String.format("Greater value bet already placed for %s.", ln));

			if (ln == null)
				throw new IllegalArgumentException(String.format("No line number supplied"));

			totalAmount += amount;
		}

		if (player.getAvailableCredits() < totalAmount)
			throw new IllegalArgumentException(String.format("Not enough credits to place all bets."));

		if (lines.isEmpty())
			throw new IllegalArgumentException(String.format("No lines selected"));

		for (LineNum ln : lines)
		{
			linesBet.put(ln, amount);
		}

		totalAmount = 0;
		for (LineNum ln : linesBet.keySet())
		{
			totalAmount += linesBet.get(ln);
		}

		player.setBet(totalAmount);

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.betUpdated(player, amount, lines);
		}
	}

	@Override
	public void placeBet(int amount, LineNum... lines) throws IllegalArgumentException, IllegalStateException
	{
		Set<LineNum> multipleLines = new HashSet<>();

		for (LineNum ln : lines)
		{
			multipleLines.add(ln);
		}

		this.placeBet(amount, multipleLines);
	}

	@Override
	public void resetBets()
	{
		player.resetBet();

		linesBet.clear();

		Collection<LineNum> collectionOfLines = new ArrayList<>();

		for (LineNum c : LineNum.values())
			collectionOfLines.add(c);

		int amount = 0;
		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.betUpdated(player, amount, collectionOfLines);
		}
	}

	@Override
	public SpinResult spinToWin(int turns, int delay) throws IllegalStateException, IllegalArgumentException
	{
		if (player == null)
			throw new IllegalStateException(String.format("No registered player."));

		if (turns < 1)
			throw new IllegalArgumentException("Turns must be greater than 0");

		if ((delay < 0) || (delay > 2000))
			throw new IllegalArgumentException("Delay must be between 1 and 2000");

		SpinResult spinToWin = spin(turns, delay);

		applySpinResult(spinToWin);

		return spinToWin;
	}

	@Override
	public SpinResult spin(int turns, int delay) throws IllegalArgumentException
	{

		if (turns < 1)
			throw new IllegalArgumentException("Turns must be greater than 0");

		if ((delay < 0) || (delay > 2000))
			throw new IllegalArgumentException("Delay must be between 1 and 2000");

		SpinResult spinResult = null;

		int turnsWheel2 = (int) (turns * WHEEL_2_PERCENTAGE);

		if (turnsWheel2 < 1)
			turnsWheel2 = 1;

		int turnsWheel3 = (int) (turns * WHEEL_3_PERCENTAGE);

		if (turnsWheel3 < 1)
			turnsWheel3 = 1;

		for (int i = 0; i < turns; i++)
		{
			this.wheel1.nextSlot();

			if (i < turnsWheel2)
				this.wheel2.nextSlot();

			if (i < turnsWheel3)
				this.wheel3.nextSlot();

			spinResult = new SpinResultImpl(this.wheel1, this.wheel2, this.wheel3);

			for (GameCallback gc : gameCallbackArrayList)
			{
				gc.turnWheel(this.wheel1, i + 1);

				if (i < turnsWheel2)
					gc.turnWheel(this.wheel2, i + 1);

				if (i < turnsWheel3)
					gc.turnWheel(this.wheel3, i + 1);
			}

			if (i < (turns - 1))
				try
				{
					Thread.sleep(delay);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}

		}

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.spinComplete(spinResult);
		}

		return spinResult;

	}

	@Override
	public int applySpinResult(SpinResult spinResult)
	{
		Iterator<SlotLine> iterator = spinResult.iterator();
		int lineOutcome = 0;
		int totalWonCredits = 0;

		while (iterator.hasNext())
		{
			boolean hasBet = false;
			SlotLine slotLine = iterator.next();

			if (linesBet.containsKey(slotLine.getLineNum()))
			{
				hasBet = true;
				lineOutcome = winSettings.getWinOdds(slotLine) * linesBet.get(slotLine.getLineNum());
				totalWonCredits += lineOutcome;
			}

			for (GameCallback gc : gameCallbackArrayList)
			{
				gc.lineResult(this.player, hasBet, lineOutcome, slotLine);
			}
		}

		player.applyWin(totalWonCredits);

		if (player.getAvailableCredits() < player.getBet())
			resetBets();

		for (GameCallback gc : gameCallbackArrayList)
		{
			gc.betTotals(this.player, totalWonCredits);
		}

		return totalWonCredits;

	}

}
