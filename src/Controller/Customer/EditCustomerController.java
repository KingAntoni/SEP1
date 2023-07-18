package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
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
        viewHandler.openView("CustomerMainView");
    }

    public void setCustomer(Customer customer) {
        firstNameTextBox.textProperty().setValue(customer.getName().split(" ")[0]);
        lastNameTextBox.setText(customer.getName().split(" ")[1]);
        phoneNumberTextBox.setText(customer.getPhoneNumber());
        emailTextBox.setText(customer.getEmail());
    }

    public void reset() {
        this.customerID=root.getUserData().toString();
        Customer customer=modelManager.readCustomer(customerID);
        setCustomer(customer);
    }

    @FXML public void saveCustomerChangesButtonPressed(){
        modelManager.updateCustomer(new Customer(firstNameTextBox.getText()+" "+lastNameTextBox.getText(),
                phoneNumberTextBox.getText(),emailTextBox.getText()));
        viewHandler.openView("CustomerMainView");
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
