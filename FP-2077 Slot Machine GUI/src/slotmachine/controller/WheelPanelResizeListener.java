package slotmachine.controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import slotmachine.view.MainWindow;
import slotmachine.view.PlayerPanel;
import slotmachine.view.StatusBar;
import slotmachine.view.ToolBar;
import slotmachine.view.WheelsPanel;

public class WheelPanelResizeListener extends ComponentAdapter
{
	private PlayerPanel playerPanel;
	private ToolBar toolBar;
	private StatusBar statusBar;
	private WheelsPanel wheelsPanel;
	private MainWindow mainWindow;

	public WheelPanelResizeListener(MainWindow mainWindow, PlayerPanel playerPanel, ToolBar toolBar,
			StatusBar statusBar, WheelsPanel wheelsPanel)
	{
		this.playerPanel = playerPanel;
		this.toolBar = toolBar;
		this.statusBar = statusBar;
		this.wheelsPanel = wheelsPanel;
		this.mainWindow = mainWindow;
	}

	@Override
	public void componentResized(ComponentEvent e)
	{
		int widthWheelsPanel = mainWindow.getWidth() - playerPanel.getWidth();
		int heightWheelsPanel = mainWindow.getHeight() - toolBar.getHeight() - (2 * statusBar.getHeight());
		int sideLength;

		if (widthWheelsPanel < heightWheelsPanel)
		{
			sideLength = widthWheelsPanel;
		} else
		{
			sideLength = heightWheelsPanel;
		}

		wheelsPanel.setSideLength(sideLength);
	}

}
