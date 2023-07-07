package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class CustomerMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    @FXML
    TableView<Customer> customerTableView;
    @FXML
    private TableColumn<Customer, String> nameColumn;

    @FXML
    private TableColumn<Customer, String> phoneNumberColumn;

    @FXML
    private TableColumn<Customer, String> emailColumn;

    @FXML
    private TableColumn<Customer, Integer> numberOfReservationsColumn;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }

    @FXML
    public void addCustomerButtonPressed(){

    }
    @FXML
    public void editCustomerButtonPressed(){

    }
    @FXML
    public void deleteCustomerButtonPressed(){

    }
    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
