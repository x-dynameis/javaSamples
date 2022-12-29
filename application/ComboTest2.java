package application;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
public class ComboTest2 extends Application{
	 public static void main(String[] args) {
	        launch(args);
//		 System.out.println("sss");
	    }

	    @Override
	    public void start(Stage primaryStage) {

	        // Simple Interface
	        VBox root = new VBox(10);
	        root.setAlignment(Pos.CENTER);
	        root.setPadding(new Insets(10));

	        // List of sample Persons
	        ObservableList<Person> persons = FXCollections.observableArrayList();
	        persons.addAll(
	                new Person("Maria Anders", "Sales Representative", "Zurich"),
	                new Person("Ana Trujillo", "Owner", "Sydney"),
	                new Person("Thomas Hardy", "Order Administrator", "Dallas")
	        );

	        // Create a simple ComboBox of Persons
	        ComboBox<Person> cboPersons = new ComboBox<>();
	        cboPersons.setItems(persons);
	        cboPersons.setEditable(true);

	        // We need a StringConverter in order to ensure the selected item is displayed properly
	        // For this sample, we only want the Person's name to be displayed
	        cboPersons.setConverter(new StringConverter<Person>() {
	            @Override
	            public String toString(Person person) {
	                if (person==null) {
	                	return "no data";
	                }else {
	                	return person.getName();
	                }
	            	
//	            	return "尾崎　博之";
	            }

	            @Override
	            public Person fromString(String string) {
	                 return null;
	            }
	        });

	        // Provide our own CellFactory to control how items are displayed
	        cboPersons.setCellFactory(cell -> new ListCell<Person>() {

	            // Create our layout here to be reused for each ListCell
	            GridPane gridPane = new GridPane();
	            Label lblName = new Label();
	            Label lblTitle = new Label();
	            Label lblLocation = new Label();

	            // Static block to configure our layout
	            {
	                // Ensure all our column widths are constant
	                gridPane.getColumnConstraints().addAll(
	                        new ColumnConstraints(100, 100, 100),
	                        new ColumnConstraints(100, 100, 100),
	                        new ColumnConstraints(100, 100, 100)
	                );

	                gridPane.add(lblName, 0, 1);
	                gridPane.add(lblTitle, 1, 1);
	                gridPane.add(lblLocation, 2, 1);

	            }

	            // We override the updateItem() method in order to provide our own layout for this Cell's graphicProperty
	            @Override
	            protected void updateItem(Person person, boolean empty) {
	                super.updateItem(person, empty);

	                if (!empty && person != null) {

	                    // Update our Labels
	                    lblName.setText(person.getName());
	                    lblTitle.setText(person.getTitle());
	                    lblLocation.setText(person.getLocation());

	                    // Set this ListCell's graphicProperty to display our GridPane
	                    setGraphic(gridPane);
	                } else {
	                    // Nothing to display here
	                    setGraphic(null);
	                }
	            }
	        });
	        TextField t1 = new TextField();
	        // Add the ComboBox to the scene
	        root.getChildren().addAll(
	                new Label("2.Select Person:"),
	                cboPersons,t1
	        );

	        // Show the stage
	        primaryStage.setScene(new Scene(root));
	        primaryStage.setTitle("Sample");
	        primaryStage.show();
	    }
	 // Simple Person class to represent our...Persons
	    class Person {

	        private final StringProperty name = new SimpleStringProperty();
	        private final StringProperty title = new SimpleStringProperty();
	        private final StringProperty location = new SimpleStringProperty();

	        Person(String name, String title, String location) {
	            this.name.set(name);
	            this.title.set(title);
	            this.location.set(location);
	        }

	        public String getName() {
	            return name.get();
	        }

	        public void setName(String name) {
	            this.name.set(name);
	        }

	        public StringProperty nameProperty() {
	            return name;
	        }

	        public String getTitle() {
	            return title.get();
	        }

	        public void setTitle(String title) {
	            this.title.set(title);
	        }

	        public StringProperty titleProperty() {
	            return title;
	        }

	        public String getLocation() {
	            return location.get();
	        }

	        public void setLocation(String location) {
	            this.location.set(location);
	        }

	        public StringProperty locationProperty() {
	            return location;
	        }
	    }
}
