package app;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
public class WindowOpen {
	private FXMLLoader loader;
	private BorderPane root;
	private DetailController controller;
	private Scene scene;
	private Stage stage;
	public WindowOpen(String formName) {
		try {
			loader = new FXMLLoader(getClass().getResource(formName));

			root = loader.load();
			controller = loader.<DetailController>getController();
			

			scene = new Scene(root);
			stage = new Stage();
			stage.setScene(scene);
			
//			stage.showAndWait();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public DetailController getController() {
		return this.controller;
	}
	public Stage getStage() {
		return this.stage;
	}


}
