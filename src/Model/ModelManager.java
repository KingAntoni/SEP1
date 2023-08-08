package Model;

import FileHandler.BusFileHandler;
import FileHandler.ChauffeurFileHandler;
import FileHandler.CustomerFileHandler;
import FileHandler.TripFileHandler;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public Customer readCustomer(String email) {
        return customerFileHandler.read(email);
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
    public void createTrip(String customerEmail, Chauffeur chauffeur, BusType busType, MyDate date, int numberOfDays , Location arrival, Location departure) {
        Trip trip = new Trip(date,findBus(busType, date, numberOfDays) ,chauffeur, readCustomer(customerEmail) ,0,new Route(arrival , departure), numberOfDays);
        tripFileHandler.create(trip);
    }

    public Trip readTrip(String id) {
        return tripFileHandler.readById(id);
    }

    public List<Trip> readAllTrips() {
        return tripFileHandler.readAll();
    }

    public void updateTrip(String customerEmail, Chauffeur chauffeur, BusType busType, MyDate date, int numberOfDays , Location arrival, Location departure) {
        Trip trip = new Trip(date,findBus(busType, date, numberOfDays) ,chauffeur, readCustomer(customerEmail) ,0,new Route(arrival , departure), numberOfDays);
        tripFileHandler.update(trip);
    }

    public void deleteTrip(String tripId) {
        tripFileHandler.delete(tripId);
    }

    public List<Chauffeur> readAllChauffeurs() {
      return  chauffeurFileHandler.readAll();
    }

    public ArrayList<Chauffeur> findChauffeurs(LocalDate selectedDate, BusType busType, int tripDuration) {
        List<Chauffeur> chauffeurs = readAllChauffeurs();
        List<Trip> trips = readAllTrips();
        ArrayList<Chauffeur> availableChauffeurs = new ArrayList<>();


        // Find available chauffeurs for each day of the trip
        for (Chauffeur chauffeur : chauffeurs) {
            boolean isAvailable = chauffeur.canDrive(busType);
            for (Trip trip : trips) {
                if (!isChauffeurAvailable(chauffeur, trip.getDateTime(), tripDuration)) {
                    isAvailable = false;
                    break;
                }
            }
            if (isAvailable) {
                availableChauffeurs.add(chauffeur);
            }
        }

        return availableChauffeurs;
    }

    // Helper method to check if a chauffeur is available on a given date for a specific duration
    private boolean isChauffeurAvailable(Chauffeur chauffeur, MyDate selectedDate, int tripDuration) {
        for (Trip trip : getTripsForChauffeur(chauffeur)) {
            if (trip.getDateTime().isEqual(selectedDate) || trip.getDateTime().isAfter(selectedDate)) {
                if (trip.getDateTime().isBefore(selectedDate.plusDays(tripDuration))) {
                    return false;
                }
            } else if (trip.getDateTime().isBefore(selectedDate)) {
                if (trip.getDateTime().plusDays(trip.getNumberOfDays()).isAfter(selectedDate)) {
                    return false;
                }
            }
        }

        return true;
    }

    public ArrayList<Trip> getTripsForChauffeur(Chauffeur chauffeur) {
        ArrayList<Trip> trips = new ArrayList<>();
        for (Trip trip : readAllTrips()) {
            if (trip.getChauffeur().equals(chauffeur)) {
                trips.add(trip);
            }
        }
        return trips;
    }
    private Bus findBus(BusType busType, MyDate date, int numberOfDays) {
        List<Bus> buses = readAllBuses();
        for (Bus bus : buses) {
                if (isBusAvailable(bus, date, numberOfDays)) {
                    return bus;
                }
        }

        throw new IllegalArgumentException("No available bus found");
    }

    private boolean isBusAvailable(Bus bus, MyDate dateTime, int numberOfDays) {
        for (Trip trip : getTripsForBus(bus)) {
            if (trip.getDateTime().isEqual(dateTime) || trip.getDateTime().isAfter(dateTime)) {
                if (trip.getDateTime().isBefore(dateTime.plusDays(numberOfDays))) {
                    return false;
                }
            } else if (trip.getDateTime().isBefore(dateTime)) {
                if (trip.getDateTime().plusDays(trip.getNumberOfDays()).isAfter(dateTime)) {
                    return false;
                }
            }
        }

        return true;
    }

    private ArrayList<Trip> getTripsForBus(Bus bus) {
        ArrayList<Trip> trips = new ArrayList<>();
        for (Trip trip : readAllTrips()) {
            if (trip.getBus().equals(bus)) {
                trips.add(trip);
            }
        }
        return trips;
    }
}
