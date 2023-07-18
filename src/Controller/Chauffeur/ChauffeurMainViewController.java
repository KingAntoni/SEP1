package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.Chauffeur;
import Model.ModelManager;
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
    private TableColumn<Chauffeur, String> preferenceColumn;
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
    public void addChauffeurButtonPressed(){
        viewHandler.openView("addChauffeur");
    }
    @FXML
    public void editChauffeurButtonPressed(){
        viewHandler.openView("editChauffeur");
    }
    @FXML
    public void deleteChauffeurButtonPressed(){

    }
    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
