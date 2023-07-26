package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.BusType;
import Model.Chauffeur;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddChauffeurController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    @FXML
    private TextField firstNameTextBox;
    @FXML
    private TextField lastNameTextBox;
    @FXML
    private TextField phoneNumberTextBox;
    @FXML
    private CheckBox partyBusCheckBox;
    @FXML
    private CheckBox schoolBusCheckBox;
    @FXML
    private CheckBox regularBusCheckBox;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }


    @FXML
    public void addChauffeurButtonPressed(){
        ArrayList<BusType> busTypes = new ArrayList<>();
        if(partyBusCheckBox.isSelected()){
            busTypes.add(BusType.PARTY_BUS);
        }if(schoolBusCheckBox.isSelected()){
            busTypes.add(BusType.SCHOOL_BUS);
        }if(regularBusCheckBox.isSelected()){
            busTypes.add(BusType.REGULAR_BUS);
        }
        modelManager.createChauffeur(new Chauffeur(firstNameTextBox.getText()+" "+lastNameTextBox.getText(),Integer.parseInt(phoneNumberTextBox.getText()),busTypes));
        viewHandler.openView("chauffeurMainView");
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("chauffeurMainView");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
