package slotmachine.model.slots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WheelImpl implements Wheel
{
	private List<SlotItem> randomisedSlotList;
	private int wheelNum;
	private static Wheel wheel;

	private WheelImpl(int wheelNum)
	{
		randomisedSlotList = new ArrayList<SlotItem>(generateSlots());
		this.wheelNum = wheelNum;

	}

	public static Wheel createWheel(int wheelNum)
	{
		wheel = new WheelImpl(wheelNum);
		return wheel;
	}

	public static List<SlotItem> generateSlots()
	{
		List<SlotItem> generatedSlotList = new ArrayList<SlotItem>();

		for (SlotItem si : SlotItem.values())
		{
			for (int i = 0; i < si.getCount(); i++)
				generatedSlotList.add(si);
		}

		Collections.shuffle(generatedSlotList);

		return generatedSlotList;
	}

	public SlotItem getTopSlot()
	{
		return randomisedSlotList.get(0);
	}

	public SlotItem getCentreSlot()
	{
		return randomisedSlotList.get(1);
	}

	public SlotItem getBottomSlot()
	{
		return randomisedSlotList.get(2);
	}

	public Wheel nextSlot()
	{
		randomisedSlotList.add(0, randomisedSlotList.get(99));
		randomisedSlotList.remove(100);

		return wheel;
	}

	@Override
	public String toString()
	{
		return String.format("Wheel #%s: %-10s / %-10s / %-10s", this.wheelNum, getTopSlot(), getCentreSlot(),
				getBottomSlot());
	}
}