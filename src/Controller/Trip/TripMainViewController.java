package Controller.Trip;

import Controller.ViewHandler;
import Model.Customer;
import Model.ModelManager;
import Model.Trip;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class TripMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    @FXML
    TableView<Trip> tripTableView;
    @FXML
    private TableColumn<Trip, String> customerEmailColumn;

    @FXML
    private TableColumn<Trip, String> chauffeurColumn;

    @FXML
    private TableColumn<Trip, String> busTypeColumn;

    @FXML
    private TableColumn<Trip, String> routeColumn;

    @FXML
    private TableColumn<Trip, Integer> tripLengthColumn;

    @FXML
    private TableColumn<Trip, String> dateColumn;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        customerEmailColumn.setCellValueFactory(cellData -> cellData.getValue().customerProperty());
        chauffeurColumn.setCellValueFactory(cellData -> cellData.getValue().chauffeurProperty());
        busTypeColumn.setCellValueFactory(cellData -> cellData.getValue().busProperty());
        routeColumn.setCellValueFactory(cellData -> cellData.getValue().locationProperty());
        tripLengthColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfDaysProperty().asObject());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());

        ObservableList<Trip> observableList = FXCollections.observableList(modelManager.readAllTrips());

        tripTableView.setItems(observableList);
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }

    @FXML
    public void addTripButtonPressed(){
        viewHandler.openView("addTrip");
    }

    @FXML
    public void deleteTripButtonPressed(){
        modelManager.deleteTrip(tripTableView.getSelectionModel().getSelectedItem().getTripID());
        reset();
    }

    @FXML
    public void editTripButtonPressed(){
        viewHandler.openView("editTrip",tripTableView.getSelectionModel().getSelectedItem().getTripID());
    }
    public void reset() {
        tripTableView.getItems().clear();
        ObservableList<Trip> observableList = FXCollections.observableList(modelManager.readAllTrips());
        tripTableView.setItems(observableList);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
