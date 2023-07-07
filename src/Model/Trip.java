package Model;

import java.time.LocalDateTime;

public class Trip {
    private LocalDateTime dateTime;
    private Bus bus;
    private Chauffeur chauffeur;
    private Customer customer;
    private int price;
    private String tripType;

    public Trip(LocalDateTime date, Bus bus, Chauffeur chauffeur, Customer customer, int price, String tripType) {
        this.dateTime = date;
        this.bus = bus;
        this.chauffeur = chauffeur;
        this.customer = customer;
        this.price = price;
        this.tripType = tripType;
    }

    public LocalDateTime getDateTime() {
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
        return price;
    }
}
