package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Trip {
    private MyDate dateTime;
    private Bus bus;
    private Chauffeur chauffeur;
    private Customer customer;
    private SimpleIntegerProperty price;
    private Route location;
    private SimpleIntegerProperty numberOfDays;
    private SimpleStringProperty tripID;

    public Trip(MyDate date, Bus bus, Chauffeur chauffeur, Customer customer, int price, Route location, int numberOfDays) {
        this.dateTime = date;
        this.bus = bus;
        this.chauffeur = chauffeur;
        this.customer = customer;
        this.price = new SimpleIntegerProperty(price);
        this.location = location;
        this.numberOfDays = new SimpleIntegerProperty(numberOfDays);
        tripID = new SimpleStringProperty(customer.getEmail() + date.toString());
    }

    public SimpleStringProperty tripIDProperty() {
        return tripID;
    }

    public SimpleIntegerProperty numberOfDaysProperty() {
        return numberOfDays;
    }

    public SimpleStringProperty locationProperty() {
        return new SimpleStringProperty(location.toString());
    }

    public SimpleStringProperty chauffeurProperty() {
        return new SimpleStringProperty(chauffeur.getName());
    }

    public SimpleStringProperty busProperty() {
        return new SimpleStringProperty(bus.getType().toString());
    }

    public SimpleStringProperty dateProperty() {
        return new SimpleStringProperty(dateTime.toString());
    }

    public SimpleStringProperty customerProperty() {
        return new SimpleStringProperty(customer.getEmail());
    }

    public SimpleStringProperty priceStringProperty() {
        return new SimpleStringProperty(price.get() + " DKK");
    }

    public MyDate getDateTime() {
        return dateTime;
    }

    public Bus getBus() {
        return bus;
    }

    public Chauffeur getChauffeur() {
        return chauffeur;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getPrice() {
        return price.get();
    }

    public Route getLocation() {
        return location;
    }

    public int getNumberOfDays() {
        return numberOfDays.get();
    }

    public String getTripID() {
        return tripID.get();
    }

    @Override
    public String toString() {
        return "Trip{" +
                "dateTime=" + dateTime +
                ", bus=" + bus +
                ", chauffeur=" + chauffeur +
                ", customer=" + customer +
                ", price=" + price +
                ", location=" + location +
                ", numberOfDays=" + numberOfDays +
                ", tripID='" + tripID + '\'' +
                '}';
    }
}
