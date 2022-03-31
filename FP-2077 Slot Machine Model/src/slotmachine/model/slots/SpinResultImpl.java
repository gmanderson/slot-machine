package slotmachine.model.slots;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class SpinResultImpl implements SpinResult
{

	private SlotLine line1;
	private SlotLine line2;
	private SlotLine line3;
	private SlotLine line4;
	private SlotLine line5;

	public SpinResultImpl(Wheel wheel1, Wheel wheel2, Wheel wheel3)
	{
		this.line1 = new SlotLineImpl(LineNum.LINE1, wheel1.getCentreSlot(), wheel2.getCentreSlot(),
				wheel3.getCentreSlot());
		this.line2 = new SlotLineImpl(LineNum.LINE2, wheel1.getTopSlot(), wheel2.getTopSlot(),
				wheel3.getTopSlot());
		this.line3 = new SlotLineImpl(LineNum.LINE3, wheel1.getBottomSlot(), wheel2.getBottomSlot(),
				wheel3.getBottomSlot());
		this.line4 = new SlotLineImpl(LineNum.LINE4, wheel1.getTopSlot(), wheel2.getCentreSlot(),
				wheel3.getBottomSlot());
		this.line5 = new SlotLineImpl(LineNum.LINE5, wheel1.getBottomSlot(), wheel2.getCentreSlot(),
				wheel3.getTopSlot());
	}

	@Override
	public Iterator<SlotLine> iterator()
	{
		Collection<SlotLine> slotLineCollection = new ArrayList<>();
		slotLineCollection.add(line1);
		slotLineCollection.add(line2);
		slotLineCollection.add(line3);
		slotLineCollection.add(line4);
		slotLineCollection.add(line5);

		return slotLineCollection.iterator();

	}

	@Override
	public String toString()
	{
		return String.format("%s\n%s\n%s", this.line2, this.line1, this.line3);

	}
}
