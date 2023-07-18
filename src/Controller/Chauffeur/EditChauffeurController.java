package Controller.Chauffeur;

import Controller.ViewHandler;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class EditChauffeurController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    private String chauffeurID;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.chauffeurID=root.getUserData().toString();
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("ChauffeurMainView");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
