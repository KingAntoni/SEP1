package Controller.Trip;

import Controller.ViewHandler;
import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.ArrayList;

public class AddTripController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    @FXML
    ChoiceBox<Chauffeur> chauffeurChoiceBox;
    @FXML
    DatePicker departureDatePicker;
    @FXML
    ChoiceBox<BusType> busTypeChoiceBox;
    @FXML
    TextField numberOfDaysTextField;
    @FXML
    ChoiceBox<Location> arrivalChoiceBox;
    @FXML
    ChoiceBox<Location> departureChoiceBox;
    @FXML
    TextField customerEmailTextField;
    @FXML
    private Label errorLabel;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        busTypeChoiceBox.getItems().addAll(BusType.values());
        departureChoiceBox.getItems().addAll(Location.values());
        arrivalChoiceBox.getItems().addAll(Location.values());

    }

    @FXML
    public void searchButtonPressed()
    {
        chauffeurChoiceBox.getItems().clear();
        ArrayList<Chauffeur> chauffeurs = modelManager.findChauffeurs(departureDatePicker.getValue(),busTypeChoiceBox.getSelectionModel().getSelectedItem(),Integer.parseInt(numberOfDaysTextField.getText()));
        if(chauffeurs.size()==0)
        {
            chauffeurChoiceBox.getItems().add(new Chauffeur("No chauffeurs available",0,new ArrayList<>()));
            chauffeurChoiceBox.getSelectionModel().select(0);
            return;
        }
        ObservableList<Chauffeur> observableList = FXCollections.observableList(chauffeurs);
        chauffeurChoiceBox.setItems(observableList);
    }

    public void reset() {
        errorLabel.setVisible(false);
        errorLabel.setText("");
        customerEmailTextField.setText("");
        chauffeurChoiceBox.getSelectionModel().clearSelection();
        busTypeChoiceBox.getSelectionModel().clearSelection();
        departureDatePicker.setValue(null);
        numberOfDaysTextField.setText("");
        arrivalChoiceBox.getSelectionModel().clearSelection();
        departureChoiceBox.getSelectionModel().clearSelection();
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }

    @FXML
    public void backButtonPressed() {
        viewHandler.openView("tripMainView");
    }

    @FXML
    public void addTripButtonPressed(){
        if (areFieldsEmpty() || !areChoiceBoxesSelected()) {
            showErrorLabel("All fields must be filled.");
        } else {
            modelManager.createTrip (customerEmailTextField.getText(), chauffeurChoiceBox.getValue(),
                    busTypeChoiceBox.getSelectionModel().getSelectedItem(),
                    MyDate.fromLocalDate(departureDatePicker.getValue()),
                    Integer.parseInt(numberOfDaysTextField.getText()),
                    arrivalChoiceBox.getSelectionModel().getSelectedItem(),
                    departureChoiceBox.getSelectionModel().getSelectedItem());
            viewHandler.openView("tripMainView");
        }
    }
    private boolean areFieldsEmpty() {
        return customerEmailTextField.getText().isEmpty()
                || departureDatePicker.getValue() == null
                || numberOfDaysTextField.getText().isEmpty();
    }
    private boolean areChoiceBoxesSelected() {
        return chauffeurChoiceBox.getValue() != null
                && busTypeChoiceBox.getSelectionModel().getSelectedItem() != null
                && arrivalChoiceBox.getSelectionModel().getSelectedItem() != null
                && departureChoiceBox.getSelectionModel().getSelectedItem() != null;
    }
    private void showErrorLabel(String message) {
        // Show the error message in the errorLabel
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
}
