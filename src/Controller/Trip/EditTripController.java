package Controller.Trip;

import Controller.ViewHandler;
import Model.ModelManager;
import javafx.scene.layout.Region;

public class EditTripController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    private String tripID;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
        this.tripID=root.getUserData().toString();
    }



    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
