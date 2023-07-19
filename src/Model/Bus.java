package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Bus {

    SimpleStringProperty name;
    SimpleObjectProperty<BusType> type;
    SimpleIntegerProperty numberOfSeats;
    SimpleStringProperty regNumber;

    public Bus(BusType type, int numberOfSeats, String regNumber, String name) {
        this.type = new SimpleObjectProperty<>(type);
        this.numberOfSeats = new SimpleIntegerProperty(numberOfSeats);
        this.regNumber = new SimpleStringProperty(regNumber);
        this.name = new SimpleStringProperty(name);
    }

    public SimpleIntegerProperty numberOfSeatsProperty() {
        return numberOfSeats;
    }

    public SimpleStringProperty regNumberProperty() {
        return regNumber;
    }

    public SimpleObjectProperty<BusType> typeProperty()  { return type; }

    public SimpleStringProperty nameProperty() {
        return name;
    }

}

