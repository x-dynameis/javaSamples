package app;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class Person {
	private final StringProperty id = new SimpleStringProperty();	
	public StringProperty idProperty() {return id;}
	public String getId() {return id.get();}
	public void setId(String id) {this.id.set(id);}
	
	private final StringProperty name = new SimpleStringProperty();
	public StringProperty nameProperty() {return name;}
	public String getName() {return name.get();}
	public void setName(String name) {this.name.set(name);}
	
	
	public Person(String id,String name) {
//		this.id = id;
//		this.name = name;
//		this.id.set(id);
//		this.name.set(name);
		idProperty().set(id);
		nameProperty().set(name);
	}
	public Person(String id) {
//		this.id.set(id);
		idProperty().set(id);
	}
	
    @Override
    public String toString(){
        return "CmbMenu[" + idProperty().get() + "," + nameProperty().get() + "]";
    }

	
    
	


}
