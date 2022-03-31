package slotmachine.model;

import javax.swing.ImageIcon;

public enum PlayerIcons
{	
	ASTRONAUT("Astronaut", "./images/astronaut.png"),
	CLOWN("Clown", "./images/clown.png"),
	HACKER("Hacker", "./images/hacker.png"),
	MONSTER("Monster", "./images/monster.png");

	private String label;
	private ImageIcon icon;
	
	PlayerIcons(String label, String iconFilename)
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
