package tools;


import java.net.URL;
import java.rmi.server.LoaderHandler;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class FxmlController {
    private final Stage thisStage;
	@FXML    private ResourceBundle resources;
    @FXML    private URL location;

    public FxmlController() {
    	thisStage = new Stage();
    	try {
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
    		loader.setController(this);
 
    		
    		
    		thisStage.setScene(new Scene(loader.load()));
    		thisStage.setTitle("Sample");
    		
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    void initialize() {
    	
    	

    }
    public void showStage() {
    	thisStage.showAndWait();
    }
}
