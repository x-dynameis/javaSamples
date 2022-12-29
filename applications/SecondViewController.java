package applications;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SecondViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField1;

    @FXML
    void initialize() {
        assert textField1 != null : "fx:id=\"textField1\" was not injected: check your FXML file 'SecondView.fxml'.";

    }
    public void stVariable(String text){
      this.textField1.setText(text);
//        label_usuario_nombre.setText(id_usuario.toString());

    }

}
