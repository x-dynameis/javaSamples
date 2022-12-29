package combotest;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
public class FXController implements Initializable{
	private ObservableList<CmbMenu> data;
	private ObjectProperty<CmbMenu> selectedData;
    @FXML
    private ComboBox<CmbMenu> cmbBox;
    @FXML
    private Label lblCmbBox;
    @FXML
    private Label lblCmbBoxSelected;
    @FXML
    private TextField text1;
	BooleanProperty blnBindBidirectional = new SimpleBooleanProperty();

	@Override
	public void initialize(URL paramURL, ResourceBundle paramResourceBundle) {

	    // コンボボックスのデータ
	    cmbBox.editableProperty().bind(blnBindBidirectional);
	    data = FXCollections.observableArrayList();
	    data.add(new CmbMenu(1,"A"));
	    data.add(new CmbMenu(2,"B"));
	    data.add(new CmbMenu(3,"C"));
	    
	    cmbBox.setItems(data);
	   
	    cmbBox.setConverter(new CmbMenu.CmbMenuStringConverter());
	    
	    selectedData = new SimpleObjectProperty<>();
	    selectedData.bind(cmbBox.getSelectionModel().selectedItemProperty());
	    lblCmbBoxSelected.textProperty().bind(selectedData.asString());

	    cmbBox.getSelectionModel().selectedItemProperty().addListener((r,o,newValue) -> {
	        if (newValue == null){
	            lblCmbBox.textProperty().set("選択なし");
	        } else {
	            lblCmbBox.textProperty().set(newValue.getTitle());
	        }
	    });
//	    cmbBox.setEditable(true);
	}
}
