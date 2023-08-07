package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class EditCustomerController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    private String customerID;

    @FXML private TextField firstNameTextBox;
    @FXML private TextField lastNameTextBox;
    @FXML private TextField phoneNumberTextBox;
    @FXML private TextField emailTextBox;
    @FXML
    private Label errorLabel;


    public void init(ViewHandler viewHandler, ModelManager modelManager, Region root, String customerId){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.customerID=customerId;
        Customer customer=modelManager.readCustomer(customerID);
setCustomer(customer);
    }
    @FXML
    public void backButtonPressed(){
        viewHandler.openView("customerMainView");
    }

    public void setCustomer(Customer customer) {
        firstNameTextBox.textProperty().setValue(customer.getName().split(" ")[0]);
        lastNameTextBox.setText(customer.getName().split(" ")[1]);
        phoneNumberTextBox.setText(customer.getPhoneNumber());
        emailTextBox.setText(customer.getEmail());
    }

    public void reset(String customerID){
        errorLabel.setVisible(false);
        errorLabel.setText("");

        // Load customer data and set it in the form again
        Customer customer = modelManager.readCustomer(customerID);
        setCustomer(customer);

    }

    @FXML
    public void saveCustomerChangesButtonPressed(){
        if (areFieldsEmpty()) {
            showErrorLabel("All fields must be filled.");
        } else {
            modelManager.updateCustomer(new Customer(firstNameTextBox.getText() + " " + lastNameTextBox.getText(),
                    phoneNumberTextBox.getText(), emailTextBox.getText()));
            viewHandler.openView("customerMainView");
        }
    }
    private boolean areFieldsEmpty() {
        return firstNameTextBox.getText().isEmpty()
                || lastNameTextBox.getText().isEmpty()
                || phoneNumberTextBox.getText().isEmpty()
                || emailTextBox.getText().isEmpty();
    }

    private void showErrorLabel(String message) {
        errorLabel.setText(message);
        errorLabel.setVisible(true);
    }
    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
