package Controller.Bus;


import Controller.ViewHandler;
import Model.Bus;
import Model.BusType;
import Model.Customer;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class BusMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    @FXML
    TableView<Bus> busTableView;

    @FXML
    private TableColumn<Bus, String> nameColumn;

    @FXML
    private TableColumn<Bus, String> regNumberColumn;

    @FXML
    private TableColumn<Bus, Integer> numberOfSeatsColumn;

    @FXML
    private TableColumn<Bus, BusType> typeColumn;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        regNumberColumn.setCellValueFactory(cellData -> cellData.getValue().regNumberProperty());
        numberOfSeatsColumn.setCellValueFactory(cellData -> cellData.getValue().numberOfSeatsProperty().asObject());
        typeColumn.setCellValueFactory(cellData -> cellData.getValue().typeProperty());

        ObservableList<Bus> observableList = FXCollections.observableList(modelManager.readAllBuses());

        busTableView.setItems(observableList);
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }
    @FXML
    public void addBusButtonPressed(){
        viewHandler.openView("addBus");
    }
    @FXML
    public void editBusButtonPressed(){
        viewHandler.openView("editBus",busTableView.getSelectionModel().getSelectedItem().regNumberProperty().getValue());
    }

    @FXML
    public void deleteBusButtonPressed(){
        modelManager.deleteBus(busTableView.getSelectionModel().getSelectedItem().regNumberProperty().getValue());
        reset();
    }

    public void reset() {
        busTableView.getItems().clear();
        ObservableList<Bus> observableList = FXCollections.observableList(modelManager.readAllBuses());
        busTableView.setItems(observableList);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
