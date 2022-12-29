package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class FormMain extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	  @Override
	  public void start(Stage primaryStage) throws Exception {
		  
			try {
				
				BorderPane root = (BorderPane)FXMLLoader.load(getClass().getResource("Form.fxml"));
				Scene scene = new Scene(root,400,400);
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
			} catch(Exception e) {
				e.printStackTrace();
			}

	  }
}
