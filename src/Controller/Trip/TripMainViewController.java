package Controller.Trip;

import Controller.ViewHandler;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class TripMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("mainFXML");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
