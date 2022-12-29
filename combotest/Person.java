package combotest;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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