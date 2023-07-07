package FileHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import Model.Chauffeur;
import com.google.gson.Gson;

public class ChauffeurFileHandler {
    private String filePath;
    private Gson gson;

    public ChauffeurFileHandler(String filePath) {
        this.filePath = filePath;
        this.gson = new Gson();
    }

    public void create(Chauffeur chauffeur) {
        List<Chauffeur> chauffeurs = getAllChauffeurs();
        chauffeurs.add(chauffeur);
        saveAllChauffeurs(chauffeurs);
    }

    public Chauffeur read(String name) {
        List<Chauffeur> chauffeurs = getAllChauffeurs();
        for (Chauffeur chauffeur : chauffeurs) {
            if (chauffeur.getName().equals(name)) {
                return chauffeur;
            }
        }
        return null;
    }

    public void update(Chauffeur updatedChauffeur) {
        List<Chauffeur> chauffeurs = getAllChauffeurs();
        for (int i = 0; i < chauffeurs.size(); i++) {
            Chauffeur chauffeur = chauffeurs.get(i);
            if (chauffeur.getName().equals(updatedChauffeur.getName())) {
                chauffeurs.set(i, updatedChauffeur);
                saveAllChauffeurs(chauffeurs);
                return;
            }
        }
    }

    public void delete(String name) {
        List<Chauffeur> chauffeurs = getAllChauffeurs();
        for (int i = 0; i < chauffeurs.size(); i++) {
            Chauffeur chauffeur = chauffeurs.get(i);
            if (chauffeur.getName().equals(name)) {
                chauffeurs.remove(i);
                saveAllChauffeurs(chauffeurs);
                return;
            }
        }
    }

    private List<Chauffeur> getAllChauffeurs() {
        List<Chauffeur> chauffeurs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Chauffeur chauffeur = gson.fromJson(line, Chauffeur.class);
                chauffeurs.add(chauffeur);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return chauffeurs;
    }

    private void saveAllChauffeurs(List<Chauffeur> chauffeurs) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Chauffeur chauffeur : chauffeurs) {
                String json = gson.toJson(chauffeur);
                writer.write(json);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
