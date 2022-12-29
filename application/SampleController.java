package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField testtextFeild;

    @FXML
    void inputButtonClick(ActionEvent event) {
    	testtextFeild.setText("サンプル");

    }

    @FXML
    void initialize() {
        assert testtextFeild != null : "fx:id=\"testtextFeild\" was not injected: check your FXML file 'Sample.fxml'.";

    }

}
