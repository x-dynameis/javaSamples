package combotest;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

public class AddCombo2 {
	public AddCombo2() {
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
            	
//            	return "尾崎　博之";
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

	}

}
