package upunushi;

public class Main {
	static MainWindow mainWindow;
	public static void main(String[] args) {
		mainWindow = new MainWindow();
		mainWindow.praparePanels();
		mainWindow.prepareComponents();
		mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
		
		mainWindow.setVisible(true);
		
	}
}
