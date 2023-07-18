package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
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


    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }
    @FXML
    public void backButtonPressed(){
        viewHandler.openView("customerMainView");
    }
    @FXML public void saveCustomerButtonPressed(){
        modelManager.createCustomer(new Customer(firstNameTextBox.getText()+" "+lastNameTextBox.getText(),
                phoneNumberTextBox.getText(),emailTextBox.getText()));
        viewHandler.openView("customerMainView");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
