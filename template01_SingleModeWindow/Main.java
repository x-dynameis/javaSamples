package template01_SingleModeWindow;

public class Main {
	static MainWindow mainWindow;
	public static void main(String[] args) {
		mainWindow = new MainWindow();
		mainWindow.praparePanels();
		mainWindow.prepareComponents();
		mainWindow.setFrontScreenAndFocus(ScreenMode.MAIN);
		
		mainWindow.setVisible(true);
		
	}
}
