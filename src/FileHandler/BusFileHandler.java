package FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Model.Bus;
import com.google.gson.Gson;

public class BusFileHandler {
    private String filePath;
    private Gson gson;
    public BusFileHandler(String filePath) {
        this.filePath = filePath;
        this.gson = new Gson();
    }

    public void create(Bus bus) {
        List<Bus> buses = getAllBuses();
        buses.add(bus);
        saveAllBuses(buses);
    }

    public Bus read(String type) {
        List<Bus> buses = getAllBuses();
        for (Bus bus : buses) {
            if (bus.getType().name().equalsIgnoreCase(type)) {
                return bus;
            }
        }
        return null;
    }

    public void update(Bus updatedBus) {
        List<Bus> buses = getAllBuses();
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.getType() == updatedBus.getType()) {
                buses.set(i, updatedBus);
                saveAllBuses(buses);
                return;
            }
        }
    }

    public void delete(String type) {
        List<Bus> buses = getAllBuses();
        for (int i = 0; i < buses.size(); i++) {
            Bus bus = buses.get(i);
            if (bus.getType().name().equalsIgnoreCase(type)) {
                buses.remove(i);
                saveAllBuses(buses);
                return;
            }
        }
    }

    private List<Bus> getAllBuses() {
        List<Bus> buses = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Bus bus = gson.fromJson(line, Bus.class);
                buses.add(bus);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buses;
    }

    private void saveAllBuses(List<Bus> buses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Bus bus : buses) {
                String json = gson.toJson(bus);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
