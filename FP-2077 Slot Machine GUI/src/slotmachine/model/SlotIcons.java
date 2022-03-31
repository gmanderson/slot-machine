package slotmachine.model;

import javax.swing.ImageIcon;

public enum SlotIcons
{	
	BERRY("Berry", "./images/berry.png"),
	FIVE("5", "./images/five.png"),
	MELON("Melon","./images/melon.png"),
	CHERRY("Cherry", "./images/cherry.png"),
	GOLD("Gold", "./images/gold.png"),
	LEMON("Lemon", "./images/lemon.png"),
	SILVER("Silver", "./images/silver.png"),
	STRAWBERRY("Strawberry", "./images/strawberry.png"),
	LIME("Lime", "./images/lime.png"),
	ONE("1", "./images/one.png"),
	THREE("3", "./images/three.png"),
	SEVEN("7", "./images/seven.png");

	private String label;
	private ImageIcon icon;
	
	SlotIcons(String label, String iconFilename)
	{
		this.label = label;
		this.icon = new ImageIcon(iconFilename, label);
	}

	public ImageIcon getIcon()
	{
		return icon;
	}
	
	public String getLabel()
	{
		return label;
	}
	
	
	@Override
	public String toString()
	{
		return label;
	}
	
	
}
