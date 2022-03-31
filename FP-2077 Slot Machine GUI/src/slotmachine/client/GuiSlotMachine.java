package slotmachine.client;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import slotmachine.model.SlotMachine;
import slotmachine.model.SlotMachineImpl;
import slotmachine.view.ConsoleLoggerCallback;
import slotmachine.view.GuiCallBack;
import slotmachine.view.MainWindow;

/**
 * The application class for <b>Slot Machine</b>.
 * <p>
 * This class launches the main window frame for the application.
 * </p>
 * 
 * @see slotmachine.view.MainWindow
 * 
 * @author Gerard Anderson
 */
public class GuiSlotMachine
{

	
	public static void main(String[] args)
	{
		try
		{
			UIManager.setLookAndFeel(new MetalLookAndFeel());
		} catch (Exception e)
		{
			System.err.println(e);
		}
		
		SlotMachine sm = new SlotMachineImpl();
		
		GuiCallBack guiCallBack = new GuiCallBack();
		sm.addCallback(guiCallBack);
		sm.addCallback(new ConsoleLoggerCallback());
		
		SwingUtilities.invokeLater(new Runnable()
		{
			
			@Override
			public void run()
			{
				new MainWindow(sm, guiCallBack).setVisible(true);
			}
		});


	}
}
