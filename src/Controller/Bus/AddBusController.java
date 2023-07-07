package Controller.Bus;
import Controller.ViewHandler;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.layout.Region;

public class AddBusController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }



    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
