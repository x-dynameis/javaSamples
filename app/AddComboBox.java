package app;
import java.sql.ResultSet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.util.StringConverter;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class AddComboBox {
	
	public AddComboBox(ComboBox<Employee> combo,String sql) {
		
	
		ObservableList<Employee> employees= FXCollections.observableArrayList();
		try {
			DBAccess db = new DBAccess();
			ResultSet rs = db.executeQuery(sql);
		while(rs.next()) {
			employees.addAll(new Employee(rs.getString(1),rs.getString(2)));
		}
		db.DisCon();
		}catch(Exception e) {
			e.printStackTrace();
		}
//		employees.addAll(
//				new Employee("1","尾崎博之"),
//				new Employee("2","尾崎美加"),
//				new Employee("3","尾崎光優")
//
//				);
		combo.setItems(employees);
		combo.setConverter(new StringConverter<Employee>(){
			@Override
			public String toString(Employee employee) {
				if(employee == null) {
					return "no data";
				}else {
					return employee.getId();
				}
				
//				try {
//					return employee.getId();
////					return null;
//				}catch(NullPointerException e) {
////					e.printStackTrace();
//					return null;
//				}
				
				
			}
			@Override
			public Employee fromString(String string) {
				return null;
			}
		});
		combo.setCellFactory(cell -> new ListCell<Employee>() {
			GridPane gridPane = new GridPane();
			Label lblId = new Label();
			Label lblName = new Label();
			
			{
				gridPane.getColumnConstraints().addAll(
						new ColumnConstraints(100,100,100),
						new ColumnConstraints(100,100,100)
						);
				gridPane.add(lblId, 0,1);
				gridPane.add(lblName, 1, 1);
				
			}
			
		@Override
		protected void updateItem(Employee employee,boolean empty) {
			super.updateItem(employee, empty);
			if(!empty && employee != null) {
				
				//Update our Labels
				lblId.setText(employee.getId());
				lblName.setText(employee.getName());
				setGraphic(gridPane);
				
			}else {
				setGraphic(null);
			}
			
			
		}
		});

		}
		
	}

