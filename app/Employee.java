package app;

//import javafx.beans.property.SimpleStringProperty;
//import javafx.beans.property.StringProperty;

public class Employee extends Person {
//private String id;
//private String name;
//	private final StringProperty id = new SimpleStringProperty();	
//	private final StringProperty name = new SimpleStringProperty();
	public Employee(String id,String name) {
		super(id,name);
//		this.id = id;
//		this.name = name;
//		this.id.set(id);
//		this.name.set(name);
	}
	public Employee(String id) {
		super(id);
//		this.id.set(id);
	}
//	
//	public String getId() {return id.get();}
//	public String getName() {return name.get();}
//	
//	public void setId(String id) {this.id.set(id);}
//	public void setName(String name) {this.name.set(name); }
//    public StringProperty nameProperty() {
//        return name;
//    }
//    public StringProperty idProperty() {
//        return id;
//    }
}
