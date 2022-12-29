package app;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class CreateAlert {
	public CreateAlert(String string) {
    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Title!");
    	alert.setHeaderText("Header!");
    	alert.setContentText("You entered: "+ string);
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.isPresent() && result.get() == ButtonType.OK) {
    		System.out.println("You clicked OK");
    	}
	}

}
