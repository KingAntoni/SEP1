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
        this.customerFileHandler = new CustomerFileHandler("src/Database/CustomerFileDB.txt");
        this.chauffeurFileHandler = new ChauffeurFileHandler("src/Database/ChauffeurFileDB.txt");
        this.busFileHandler = new BusFileHandler("src/Database/BusFileDB.txt");
        this.tripFileHandler = new TripFileHandler("src/Database/TripFileDB.txt");
    }

    // Customer methods
    public void createCustomer(Customer customer) {
        customerFileHandler.create(customer);
    }

    public Customer readCustomer(String name) {
        return customerFileHandler.read(name);
    }

    public List<Customer> readAllCustomers() {
        return customerFileHandler.readAll();
    }

    public void updateCustomer(Customer updatedCustomer) {
        customerFileHandler.update(updatedCustomer);
    }

    public void deleteCustomer(String email) {
        customerFileHandler.delete(email);
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

    public Bus readBus(String licencePlate) {
        return busFileHandler.read(licencePlate);
    }

    public List<Bus> readAllBuses() {
        return busFileHandler.readAll();
    }

    public void updateBus(Bus updatedBus) {
        busFileHandler.update(updatedBus);
    }

    public void deleteBus(String licencePlate) {
        busFileHandler.delete(licencePlate);
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
