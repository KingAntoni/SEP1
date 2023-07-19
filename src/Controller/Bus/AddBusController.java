package Controller.Bus;
import Controller.ViewHandler;
import Model.Bus;
import Model.BusType;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.util.Arrays;
import java.util.List;

public class AddBusController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    @FXML
    private TextField busNameTextBox;
    @FXML
    private TextField busRegNumberTextBox;
    @FXML
    private TextField noSeatsTextBox;
    @FXML
    private ChoiceBox<BusType> typeChoiceBox;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        typeChoiceBox.setItems(FXCollections.observableArrayList(Arrays.asList(BusType.values())));
    }

    @FXML
    public void saveBusButtonPressed(){
        modelManager.createBus(new Bus(typeChoiceBox.getValue(), Integer.parseInt(noSeatsTextBox.getText()), busRegNumberTextBox.getText(), busNameTextBox.getText()));
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
