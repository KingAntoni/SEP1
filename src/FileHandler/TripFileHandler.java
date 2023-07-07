package FileHandler;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import Model.Trip;
import com.google.gson.Gson;
import java.time.format.DateTimeFormatter;

public class TripFileHandler {
    private String filePath;
    private Gson gson;
    private DateTimeFormatter formatter;

    public TripFileHandler(String filePath) {
        this.filePath = filePath;
        this.gson = new Gson();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    public void create(Trip trip) {
        List<Trip> trips = getAllTrips();
        trips.add(trip);
        saveAllTrips(trips);
    }

    public List<Trip> readAll() {
        return getAllTrips();
    }

    public void update(Trip updatedTrip) {
        List<Trip> trips = getAllTrips();
        for (int i = 0; i < trips.size(); i++) {
            Trip trip = trips.get(i);
            if (trip.getDateTime().equals(updatedTrip.getDateTime())
                    && trip.getBus().equals(updatedTrip.getBus())
                    && trip.getChauffeur().equals(updatedTrip.getChauffeur())
                    && trip.getCustomer().equals(updatedTrip.getCustomer())) {
                trips.set(i, updatedTrip);
                saveAllTrips(trips);
                return;
            }
        }
    }

    public void delete(Trip trip) {
        List<Trip> trips = getAllTrips();
        trips.remove(trip);
        saveAllTrips(trips);
    }

    private List<Trip> getAllTrips() {
        List<Trip> trips = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Trip trip = gson.fromJson(line, Trip.class);
                trips.add(trip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return trips;
    }

    private void saveAllTrips(List<Trip> trips) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Trip trip : trips) {
                String json = gson.toJson(trip);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
