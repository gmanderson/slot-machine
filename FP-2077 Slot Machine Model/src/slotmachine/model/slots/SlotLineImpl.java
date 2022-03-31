package slotmachine.model.slots;

import java.util.Objects;

public class SlotLineImpl implements SlotLine
{
	private LineNum lineNum;
	private SlotItem slot1;
	private SlotItem slot2;
	private SlotItem slot3;

	public SlotLineImpl(LineNum lineNum, SlotItem slot1, SlotItem slot2, SlotItem slot3)
	{
		this.lineNum = lineNum;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
	}

	public LineNum getLineNum()
	{
		return lineNum;
	}

	public SlotItem getSlot1()
	{
		return slot1;
	}

	public SlotItem getSlot2()
	{
		return slot2;
	}

	public SlotItem getSlot3()
	{
		return slot3;
	}

	@Override
	public boolean equals(SlotLine slotLine)
	{
		return (slotLine != null) && (this.slot1 == slotLine.getSlot1()) 
				&& (this.slot2 == slotLine.getSlot2())
				&& (this.slot3 == slotLine.getSlot3());
	}

	@Override
	public boolean equals(Object obj)
	{
		// Compares two objects' memory addresses by default
		// Checks for safe cast. Null is not an instance of anything.
		return obj instanceof SlotLine && equals((SlotLine) obj);
	}

	@Override
	public int hashCode()
	{
		return Objects.hash(this.slot1, this.slot2, this.slot3);
	}

	@Override
	public String toString()
	{
		return String.format("%s | %-10s | %-10s | %-10s |", this.lineNum, this.slot1, this.slot2, this.slot3);
	}
}
