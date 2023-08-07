package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.BusType;
import Model.Chauffeur;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    @FXML
    private Label errorLabel;

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
        viewHandler.openView("chauffeurMainView");
    }
    @FXML
    public void saveChauffeurButtonPressed(){
        // Check if any of the fields are empty or no bus type is selected
        if (areFieldsEmpty() || !isBusTypeSelected()) {
            // Show error message and deny permission to update the chauffeur
            showErrorLabel("All fields must be filled.");
        } else {
            // Fields are not empty and bus type is selected, proceed with updating the chauffeur
            ArrayList<BusType> busTypes = new ArrayList<>();
            if(partyBusCheckBox.isSelected()){
                busTypes.add(BusType.PARTY_BUS);
            }if(schoolBusCheckBox.isSelected()){
                busTypes.add(BusType.SCHOOL_BUS);
            }if(regularBusCheckBox.isSelected()){
                busTypes.add(BusType.REGULAR_BUS);
            }
            modelManager.updateChauffeur(new Chauffeur(firstNameTextBox.getText() + " " + lastNameTextBox.getText(), Integer.parseInt(phoneNumberTextBox.getText()), busTypes));
            viewHandler.openView("chauffeurMainView");
        }
    }
    private boolean areFieldsEmpty() {
        // Check if any of the fields are empty
        return firstNameTextBox.getText().isEmpty()
                || lastNameTextBox.getText().isEmpty()
                || phoneNumberTextBox.getText().isEmpty();
    }
    private boolean isBusTypeSelected() {
        // Check if at least one bus type is selected
        return partyBusCheckBox.isSelected()
                || schoolBusCheckBox.isSelected()
                || regularBusCheckBox.isSelected();
    }
    private void showErrorLabel(String message) {
        // Show the error message in the errorLabel
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    public void reset(String chauffeurID) {
        Chauffeur chauffeur=modelManager.readChauffeur(chauffeurID);
        setChauffeur(chauffeur);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
