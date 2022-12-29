package application0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class SampleController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> txtId;

    @FXML
    private TableColumn<?, ?> txtName;

    @FXML
    private TableColumn<?, ?> txtPhonetics;
  

    @FXML
    void initialize() {
        assert txtId != null : "fx:id=\"txtId\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'Sample.fxml'.";
        assert txtPhonetics != null : "fx:id=\"txtPhonetics\" was not injected: check your FXML file 'Sample.fxml'.";

    }
    
    

}
