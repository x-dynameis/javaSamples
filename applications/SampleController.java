package applications;

import java.io.IOException;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.Scene;
public class SampleController {

    @FXML    private ResourceBundle resources;
    @FXML    private URL location;
    @FXML    private TextField textField1;
    @FXML    private Button button1;
    @FXML    private ComboBox<Employee> combo1;
    @FXML    private Button button2;
    private ObservableList data;
    @FXML
    void onButton1Action(ActionEvent event) {

    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title!");
    	alert.setHeaderText("Header!");
    	alert.setContentText("You entered: " + textField1.getText());
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    		System.out.println("You clicked OK");
    	}
    }
    @FXML
    void onButton2Action(ActionEvent event) {
    	try {
    		showSecondWindow();
    		
    	}catch(Exception ex) {
    		System.out.println(ex.getMessage());
    	}
    }


    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'Sample.fxml'.";
        assert combo1 != null : "fx:id=\"combo1\" was not injected: check your FXML file 'Sample.fxml'.";
        assert textField1 != null : "fx:id=\"textField1\" was not injected: check your FXML file 'Sample.fxml'.";
//        combo1.setEditable(true); 
        new AddComboBox(combo1,"select id,name from t_user where retire = 0");
         
        
    }
    void showSecondWindow() throws IOException{
    	FXMLLoader loader = new FXMLLoader(getClass().getResource("SecondView.fxml"));
    	AnchorPane root = (AnchorPane) loader.load();
    	SecondViewController controller = loader.<SecondViewController>getController();
    	controller.stVariable("にん！！！");
    	Scene scene = new Scene(root);
    	Stage stage = new Stage();
    	stage.setScene(scene);
    	stage.showAndWait();
    }
}
