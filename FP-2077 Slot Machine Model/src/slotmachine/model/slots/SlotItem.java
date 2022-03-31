package slotmachine.model.slots;

/**
 * Supporting enum used in the <b>Further Programming Assignment</b>
 * <p>
 * The values in this enum are use to represent a single slot item on a wheel.
 * <p>
 * Each {@link Wheel} is made up of 100 {@link SlotItem} with {@link #count}
 * number of each {@link SlotItem} value. e.g. There are two {@link #GOLD} 
 * and 7 {@link #LIME} on each wheel
 * <p>
 * <b>Note:</b> You are <b>not</b> permitted to change this enum in any way
 * (aside from during your own testing). The submitted enum must exactly match
 * the start up code.
 * 
 * @author Ross Nye
 */
public enum SlotItem
{
	ONE("1", 22),
	THREE("3", 18),
	FIVE("5", 14),
	SEVEN("7", 11),
	LEMON("Lemon", 8),
	LIME("Lime", 7),	
	BERRY("Berry",6),
	CHERRY("Cherry", 5),
	MELON("Melon", 4),
	SILVER("Silver Bar", 3),
	GOLD("Gold Bar", 2);

	private String label;
	private int count;
	
	private SlotItem(String label, int count)
	{
		this.label = label;
		this.count = count;
	}
	
	/**
	 * Returns a String representation of the SlotItem, which is the supplied 
	 * label.
	 */
	@Override
	public String toString()
	{
		return label;
	}
	
	/**
	 * @return the amount of the SlotItem on a fully populated wheel.
	 */
	public int getCount()
	{
		return count;
	}
}
