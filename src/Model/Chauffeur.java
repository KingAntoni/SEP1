package Model;
import javafx.beans.property.*;

import java.util.ArrayList;
import java.util.List;

public class Chauffeur {
    private SimpleStringProperty name;
    private List<SimpleObjectProperty<BusType>> preferences;
    private SimpleIntegerProperty phoneNumber;

    public Chauffeur(String name, int phoneNumber, List<BusType> preferences) {
        this.name =new SimpleStringProperty(name);
        this.preferences = new ArrayList<>();
        this.phoneNumber =new SimpleIntegerProperty(phoneNumber);
        for (BusType preference : preferences) {
            this.preferences.add(new SimpleObjectProperty<>(preference));
        }
    }

    public String getName() {
        return name.get();
    }


    public List<String> getPreferences() {
        List<String> preferences = new ArrayList<>();
        for (SimpleObjectProperty<BusType> preference : this.preferences) {
            preferences.add(preference.get().toString());
        }
        return preferences;
    }

    public void addPreference(String preference) {
        preferences.add(new SimpleObjectProperty<>(BusType.valueOf(preference)));
    }

    public void removePreference(String preference) {
        preferences.remove(preference);
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public SimpleIntegerProperty phoneNumberProperty() {
        return phoneNumber;
    }

    public SimpleObjectProperty<BusType> preferenceProperty(int index) {
        return preferences.get(index);
    }

    public SimpleStringProperty preferencesProperty() {
        String x = "";
        for(SimpleObjectProperty<BusType> preference : preferences) {
            x += preference.get().toString() + ", ";
        }
        return new SimpleStringProperty(x);
    }

    public String getPhoneNumber() {
        return String.valueOf(phoneNumber.get());
    }

    public boolean canDrive(BusType busType) {
        for (SimpleObjectProperty<BusType> preference : preferences) {
            if (preference.get().equals(busType)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return getName() +
                ", " + getPhoneNumber();
    }
}

