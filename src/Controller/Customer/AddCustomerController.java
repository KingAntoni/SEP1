package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddCustomerController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    @FXML private TextField firstNameTextBox;
    @FXML private TextField lastNameTextBox;
    @FXML private TextField phoneNumberTextBox;
    @FXML private TextField emailTextBox;
    @FXML
    private Label errorLabel;


    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }
    @FXML
    public void backButtonPressed(){
        viewHandler.openView("customerMainView");
    }
    @FXML
    public void saveCustomerButtonPressed(){
        // Check if any of the fields are empty
        if (areFieldsEmpty()) {
            // Show error message and deny permission to add the customer
            showErrorLabel("All fields must be filled.");
        } else {
            // Fields are not empty, proceed with adding the customer
            modelManager.createCustomer(new Customer(firstNameTextBox.getText() + " " + lastNameTextBox.getText(),
                    phoneNumberTextBox.getText(), emailTextBox.getText()));
            viewHandler.openView("customerMainView");
        }
    }
    private boolean areFieldsEmpty() {
        // Check if any of the fields are empty
        return firstNameTextBox.getText().isEmpty()
                || lastNameTextBox.getText().isEmpty()
                || phoneNumberTextBox.getText().isEmpty()
                || emailTextBox.getText().isEmpty();
    }
    private void showErrorLabel(String message) {
        // Show the error message in the errorLabel
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    public void reset() {
        errorLabel.setVisible(false);
        errorLabel.setText("");
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
