package Controller;

import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class MainFXMLController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }

    @FXML
    public void manageBusesButtonPressed(){
        viewHandler.openView("busMainView");
    }
    @FXML
    public void manageCustomersButtonPressed(){
        viewHandler.openView("customerMainView");
    }
    @FXML
    public void manageChauffeursButtonPressed(){
        viewHandler.openView("chauffeurMainView");
    }
    @FXML
    public void manageTripsButtonPressed(){
        viewHandler.openView("tripMainView");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
