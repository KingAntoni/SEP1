package Controller.Bus;

import Controller.ViewHandler;
import Model.ModelManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class EditBusController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    private String busID;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.busID=root.getUserData().toString();
    }

    @FXML
    public void backButtonPressed(){
        viewHandler.openView("BusMainView");
    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }

    @FXML
    public void saveButtonPressed(ActionEvent actionEvent) {
    }
}

