package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private TextField testTextFeild;

    @FXML
    void onGetButtonClick(ActionEvent event) {
    	

    }

    @FXML
    void onInputButtonClick(ActionEvent event){
    	try {
    	testTextFeild.setText("サンプルテキスト");
    	}catch (Exception e) {
    		System.out.println("何かのエラーです");
    	}

    }

    @FXML
    void initialize() {
        assert button1 != null : "fx:id=\"button1\" was not injected: check your FXML file 'Form.fxml'.";
        assert button2 != null : "fx:id=\"button2\" was not injected: check your FXML file 'Form.fxml'.";
        assert testTextFeild != null : "fx:id=\"testTextFeild\" was not injected: check your FXML file 'Form.fxml'.";

    }

}
