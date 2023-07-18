package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Customer {
    SimpleStringProperty name;
    SimpleStringProperty phoneNumber;
    SimpleStringProperty email;
    SimpleIntegerProperty numberOfReservations;
    public Customer() {
        this(null, null,null);
    }
    public Customer(String name, String phoneNumber, String email) {
        this.name = new SimpleStringProperty(name);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.email = new SimpleStringProperty(email);
        this.numberOfReservations = new SimpleIntegerProperty(0);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.get();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.set(phoneNumber);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public int getNumberOfReservations() {
        return numberOfReservations.get();
    }

    public void setNumberOfReservations(int numberOfReservations) {
        this.numberOfReservations.set(numberOfReservations);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }
public SimpleStringProperty phoneNumberProperty() {
        return phoneNumber;
    }
    public SimpleIntegerProperty numberOfReservationsProperty() {
        return numberOfReservations;
    }
}
