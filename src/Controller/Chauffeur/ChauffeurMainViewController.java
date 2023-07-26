package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.Bus;
import Model.Chauffeur;
import Model.ModelManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;


public class ChauffeurMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    @FXML
    TableView<Chauffeur> chauffeurTable;

    @FXML
    private TableColumn<Chauffeur, String> nameColumn;
    @FXML
    private TableColumn<Chauffeur, String> preferencesColumn;
    @FXML
    private TableColumn<Chauffeur, Integer> phoneColumn;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;

        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        preferencesColumn.setCellValueFactory(cellData -> cellData.getValue().preferencesProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneNumberProperty().asObject());

        ObservableList<Chauffeur> observableList = FXCollections.observableList(modelManager.readAllChauffeurs());

        chauffeurTable.setItems(observableList);
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }

    @FXML
    public void addChauffeurButtonPressed(){
        viewHandler.openView("addChauffeur");
    }
    @FXML
    public void editChauffeurButtonPressed(){
        viewHandler.openView("editChauffeur", chauffeurTable.getSelectionModel().getSelectedItem().getPhoneNumber());
    }
    @FXML
    public void deleteChauffeurButtonPressed(){
        modelManager.deleteChauffeur(chauffeurTable.getSelectionModel().getSelectedItem().getPhoneNumber());
        reset();
    }
    public void reset() {
        ObservableList<Chauffeur> observableList = FXCollections.observableList(modelManager.readAllChauffeurs());
        chauffeurTable.setItems(observableList);
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
