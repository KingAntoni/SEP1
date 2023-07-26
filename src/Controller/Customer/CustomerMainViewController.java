package Controller.Customer;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

    public void init(ViewHandler viewHandler, ModelManager modelManager, Region root) {
        this.viewHandler = viewHandler;
        this.modelManager = modelManager;
        this.root = root;

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        phoneNumberColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        numberOfReservationsColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfReservationsProperty().asObject());

        ObservableList<Customer> observableList = FXCollections.observableList(modelManager.readAllCustomers());

        customerTableView.setItems(observableList);
    }


    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }

    @FXML
    public void addCustomerButtonPressed(){
        viewHandler.openView("addCustomer");
    }
    @FXML
    public void editCustomerButtonPressed(){
        viewHandler.openView("editCustomer",customerTableView.getSelectionModel().getSelectedItem().getEmail());
    }
    @FXML
    public void deleteCustomerButtonPressed(){
        modelManager.deleteCustomer(customerTableView.getSelectionModel().getSelectedItem().getEmail());
        reset();
    }
    public void reset() {
        customerTableView.getItems().clear();
        ObservableList<Customer> observableList = FXCollections.observableList(modelManager.readAllCustomers());
        customerTableView.setItems(observableList);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
