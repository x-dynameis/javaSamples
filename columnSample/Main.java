package columnSample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private TableView<Person> table = new TableView<>();
    private ObservableList<Person> data = FXCollections.observableArrayList(
            new Person(false, "Jacob", "Smith", "jacob.smith@example.com"),
            new Person(false, "Isabella", "Johnson", "isabella.johnson@example.com"),
            new Person(false, "Ethan", "Williams", "ethan.williams@example.com"),
            new Person(false, "Emma", "Jones", "emma.jones@example.com"),
            new Person(false, "Michael", "Brown", "michael.brown@example.com"));

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Table View Sample");
        stage.setWidth(515);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial", 20));

        CheckBoxColumn checkBoxCol = new CheckBoxColumn();
        checkBoxCol.setMinWidth(50);

        TableColumn<Person, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Person, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Person, String> emailCol = new TableColumn<>("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        // なぜかテーブル全体をeditableにしないとチェックボックスが押せない…
        table.setEditable(true);

        // マウスクリック時に動作する
        table.setOnMouseClicked(event -> {
        	
            System.out.println( "行が選択されたぜ！！");
        });

        table.setItems(data);
        table.getColumns().add(checkBoxCol);
        table.getColumns().add(firstNameCol);
        table.getColumns().add(lastNameCol);
        table.getColumns().add(emailCol);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }

}