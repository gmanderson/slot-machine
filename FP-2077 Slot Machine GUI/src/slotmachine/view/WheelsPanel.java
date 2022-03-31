package slotmachine.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import slotmachine.model.SlotIcons;
import slotmachine.model.SlotMachine;
import slotmachine.model.slots.SlotItem;

/**
 * The Wheels Panel for <b>Slot Machine</b>.
 * <p>
 * This class constructs the Wheels panel on the main window. The Wheels Panel
 * currently loads images of slot items upon application loading and assigns
 * them to a collection that is drawn by overriding paintComponent().
 * </p>
 * <p>
 * Slot item selection currently static.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */

@SuppressWarnings("serial")
public class WheelsPanel extends JPanel implements PropertyChangeListener
{

	private int sideLength;
	private List<Image> imageCollection;
	private static final int NUM_WHEELS = 3;
	private static final int SLOTS_PER_WHEEL = 3;
	private static final int NUM_WHEEL_DIVIDERS = NUM_WHEELS - 1;
	private static final int START_COORDINATE = 0;
	private static final int PANEL_EDGE_BUFFER = 5;
	private static final int PANEL_SIZE_BUFFER = 10;

	public WheelsPanel(SlotMachine sm, GuiCallBack gcb)
	{
		super();

		gcb.addPropertyChangeListener(this);

		imageCollection = new ArrayList<>();
		for (int i = 0; i < 9; i++)
		{
			imageCollection.add(SlotIcons.SEVEN.getIcon().getImage());
		}

		setBackground(new Color(255, 255, 230));
	}

	/**
	 * <p>
	 * Overrides paintComponent() to allow for redraw when the main window is
	 * resized. Images and component canvas resize in equal ratio.
	 * </p>
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		setSize(sideLength, sideLength);

		g.drawLine(sideLength / NUM_WHEELS, START_COORDINATE, sideLength / NUM_WHEELS, sideLength);
		g.drawLine((sideLength / NUM_WHEELS) * NUM_WHEEL_DIVIDERS, START_COORDINATE,
				(sideLength / NUM_WHEELS) * NUM_WHEEL_DIVIDERS, sideLength);

		Iterator<Image> imageIterator = imageCollection.iterator();

		int x = START_COORDINATE;
		int y = START_COORDINATE;
		// Draws 3x3 grid of slot items.
		for (int i = 0; i < SLOTS_PER_WHEEL; i++)
		{
			for (int j = 0; j < NUM_WHEELS; j++)
			{

				g.drawImage(imageIterator.next(), x + PANEL_EDGE_BUFFER, y + PANEL_EDGE_BUFFER, // CHANGE FROM LITERAL
						(sideLength / NUM_WHEELS) - PANEL_SIZE_BUFFER, (sideLength / NUM_WHEELS) - PANEL_SIZE_BUFFER,
						null);
				x += sideLength / NUM_WHEELS;
			}

			y += sideLength / NUM_WHEELS;
			x = START_COORDINATE;
		}

		g.drawString("Line1", 0, sideLength / 6 * 3);
		g.drawString("Line2", 0, sideLength / 6);
		g.drawString("Line3", 0, sideLength / 6 * 5);
		g.drawString("Line4", 0, 10);
		g.drawString("Line5", 0, sideLength);
	}

	/**
	 * <p>
	 * Simple setter for length of sides of wheels panel.
	 * </p>
	 * 
	 * @param sideLength The length of each side of the Wheels panel.
	 */
	public void setSideLength(int sideLength)
	{
		this.sideLength = sideLength;
	}

	public ImageIcon pickIcon(SlotItem si)
	{
		ImageIcon slot = null;
		switch (si)
		{
		case ONE:
			slot = SlotIcons.ONE.getIcon();
			break;
		case THREE:
			slot = SlotIcons.THREE.getIcon();
			break;
		case FIVE:
			slot = SlotIcons.FIVE.getIcon();
			break;
		case SEVEN:
			slot = SlotIcons.SEVEN.getIcon();
			break;
		case BERRY:
			slot = SlotIcons.BERRY.getIcon();
			break;
		case CHERRY:
			slot = SlotIcons.CHERRY.getIcon();
			break;
		case MELON:
			slot = SlotIcons.MELON.getIcon();
			break;
		case GOLD:
			slot = SlotIcons.GOLD.getIcon();
			break;
		case SILVER:
			slot = SlotIcons.SILVER.getIcon();
			break;
		case LEMON:
			slot = SlotIcons.LEMON.getIcon();
			break;
		case LIME:
			slot = SlotIcons.LIME.getIcon();
			break;
		}

		return slot;
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt)
	{

		if (evt.getPropertyName() == "WHEEL1TOP")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(0, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL1CENTRE")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(3, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL1BOTTOM")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(6, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL2TOP")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(1, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL2CENTRE")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(4, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL2BOTTOM")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(7, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL3TOP")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(2, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL3CENTRE")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(5, slot.getImage());

		}

		if (evt.getPropertyName() == "WHEEL3BOTTOM")
		{
			SlotItem si = (SlotItem) evt.getNewValue();
			;

			ImageIcon slot = pickIcon(si);

			imageCollection.set(8, slot.getImage());

		}
		revalidate();

	}

}
