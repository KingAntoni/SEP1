package Controller.Bus;

import Controller.ViewHandler;
import Model.Bus;
import Model.BusType;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.Arrays;

public class EditBusController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    private String licencePlate;
    @FXML
    private TextField busNameTextBox;
    @FXML
    private TextField busRegNumberTextBox;
    @FXML
    private TextField noSeatsTextBox;
    @FXML
    private ChoiceBox<BusType> typeChoiceBox;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root, String licencePlate){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.licencePlate = licencePlate;

        typeChoiceBox.setItems(FXCollections.observableArrayList(Arrays.asList(BusType.values())));

        Bus bus = modelManager.readBus(licencePlate);
        setBus(bus);
    }

    private void setBus(Bus bus) {
        busNameTextBox.setText(bus.nameProperty().getValue());
        busRegNumberTextBox.setText(bus.regNumberProperty().getValue());
        noSeatsTextBox.setText(bus.numberOfSeatsProperty().getValue().toString());
        typeChoiceBox.setValue(bus.typeProperty().getValue());
    }

    @FXML
    public void saveBusButtonPressed(){
        modelManager.updateBus(new Bus(typeChoiceBox.getValue(), Integer.parseInt(noSeatsTextBox.getText()), busRegNumberTextBox.getText(), busNameTextBox.getText()));
        viewHandler.openView("busMainView");
    }


    @FXML
    public void backButtonPressed(){
        viewHandler.openView("busMainView");
    }
    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}

