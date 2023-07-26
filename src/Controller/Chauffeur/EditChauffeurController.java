package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.BusType;
import Model.Chauffeur;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class EditChauffeurController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    private String chauffeurID;
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
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root,String chauffeurID){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.chauffeurID=chauffeurID;
        Chauffeur chauffeur=modelManager.readChauffeur(chauffeurID);
        setChauffeur(chauffeur);
    }
    public void setChauffeur(Chauffeur chauffeur) {
        firstNameTextBox.textProperty().setValue(chauffeur.getName().split(" ")[0]);
        lastNameTextBox.setText(chauffeur.getName().split(" ")[1]);
        phoneNumberTextBox.setText(chauffeur.getPhoneNumber());
        if(chauffeur.getPreferences().contains("Party Bus")){
            partyBusCheckBox.setSelected(true);}
        if(chauffeur.getPreferences().contains("School Bus")){
            schoolBusCheckBox.setSelected(true);}
        if(chauffeur.getPreferences().contains("Regular Bus")){
            regularBusCheckBox.setSelected(true);}
        }

        @FXML
    public void backButtonPressed(){
        viewHandler.openView("ChauffeurMainView");
    }
@FXML
public void saveChauffeurButtonPressed()
{
    ArrayList<BusType> busTypes = new ArrayList<>();
    if(partyBusCheckBox.isSelected()){
        busTypes.add(BusType.PARTY_BUS);
    }if(schoolBusCheckBox.isSelected()){
    busTypes.add(BusType.SCHOOL_BUS);
}if(regularBusCheckBox.isSelected()){
    busTypes.add(BusType.REGULAR_BUS);
}
    modelManager.updateChauffeur(new Chauffeur(firstNameTextBox.getText()+" "+lastNameTextBox.getText(),Integer.parseInt(phoneNumberTextBox.getText()),busTypes));
    viewHandler.openView("chauffeurMainView");
}
    public void reset(String chauffeurID) {
        Chauffeur chauffeur=modelManager.readChauffeur(chauffeurID);
        setChauffeur(chauffeur);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
