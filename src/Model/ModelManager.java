package Model;

import FileHandler.BusFileHandler;
import FileHandler.ChauffeurFileHandler;
import FileHandler.CustomerFileHandler;
import FileHandler.TripFileHandler;
import java.util.List;

public class ModelManager {
    private CustomerFileHandler customerFileHandler;
    private ChauffeurFileHandler chauffeurFileHandler;
    private BusFileHandler busFileHandler;
    private TripFileHandler tripFileHandler;

    public ModelManager() {
        this.customerFileHandler = new CustomerFileHandler("Database.CustomerFileDB");
        this.chauffeurFileHandler = new ChauffeurFileHandler("Database.ChauffeurFileDB");
        this.busFileHandler = new BusFileHandler("Database.BusFileDB");
        this.tripFileHandler = new TripFileHandler("Database.TripFileDB");
    }

    // Customer methods
    public void createCustomer(Customer customer) {
        customerFileHandler.create(customer);
    }

    public Customer readCustomer(String name) {
        return customerFileHandler.read(name);
    }

    public void updateCustomer(Customer updatedCustomer) {
        customerFileHandler.update(updatedCustomer);
    }

    public void deleteCustomer(String name) {
        customerFileHandler.delete(name);
    }

    // Chauffeur methods
    public void createChauffeur(Chauffeur chauffeur) {
        chauffeurFileHandler.create(chauffeur);
    }

    public Chauffeur readChauffeur(String name) {
        return chauffeurFileHandler.read(name);
    }

    public void updateChauffeur(Chauffeur updatedChauffeur) {
        chauffeurFileHandler.update(updatedChauffeur);
    }

    public void deleteChauffeur(String name) {
        chauffeurFileHandler.delete(name);
    }

    // Bus methods
    public void createBus(Bus bus) {
        busFileHandler.create(bus);
    }

    public Bus readBus(String type) {
        return busFileHandler.read(type);
    }

    public void updateBus(Bus updatedBus) {
        busFileHandler.update(updatedBus);
    }

    public void deleteBus(String type) {
        busFileHandler.delete(type);
    }

    // Trip methods
    public void createTrip(Trip trip) {
        tripFileHandler.create(trip);
    }

    public List<Trip> readAllTrips() {
        return tripFileHandler.readAll();
    }

    public void updateTrip(Trip updatedTrip) {
        tripFileHandler.update(updatedTrip);
    }

    public void deleteTrip(Trip trip) {
        tripFileHandler.delete(trip);
    }
}
