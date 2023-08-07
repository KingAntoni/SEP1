package Controller.Bus;
import Controller.ViewHandler;
import Model.Bus;
import Model.BusType;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
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
    @FXML
    private Label errorLabel;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        typeChoiceBox.setItems(FXCollections.observableArrayList(Arrays.asList(BusType.values())));
    }

    @FXML
    public void saveBusButtonPressed(){
        if (areFieldsEmpty()) {
            showErrorLabel("All fields must be filled.");
        } else {
            modelManager.createBus(new Bus(typeChoiceBox.getValue(), Integer.parseInt(noSeatsTextBox.getText()), busRegNumberTextBox.getText(), busNameTextBox.getText()));
            viewHandler.openView("busMainView");
        }
    }
    private boolean areFieldsEmpty() {
        return busNameTextBox.getText().isEmpty()
                || busRegNumberTextBox.getText().isEmpty()
                || noSeatsTextBox.getText().isEmpty()
                || typeChoiceBox.getValue() == null;
    }

    private void showErrorLabel(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }


    @FXML
    public void backButtonPressed(){
        viewHandler.openView("busMainView");
    }
    public void reset() {
        errorLabel.setVisible(false);
        errorLabel.setText("");
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
