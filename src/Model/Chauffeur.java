package Model;
import java.util.ArrayList;
import java.util.List;

public class Chauffeur {
    private String name;
    private List<String> preferences;

    public Chauffeur(String name, boolean available) {
        this.name = name;
        this.preferences = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public List<String> getPreferences() {
        return preferences;
    }

    public void addPreference(String preference) {
        preferences.add(preference);
    }

    public void removePreference(String preference) {
        preferences.remove(preference);
    }

}

