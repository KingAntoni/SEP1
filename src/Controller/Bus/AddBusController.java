package Controller.Bus;
import Controller.ViewHandler;
import Model.Bus;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class AddBusController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;

    @FXML
    private TextField busNameTextBox;
    @FXML
    private TextField noSeatsTextBox;

    public void init(ViewHandler viewHandler, ModelManager modelManager,Region root){
        this.viewHandler=viewHandler;
        this.modelManager=modelManager;
        this.root=root;
    }

    @FXML
    public void saveBusButtonPressed(){
        modelManager.createBus(new Bus(busNameTextBox.getText(),Integer.parseInt(noSeatsTextBox.getText(),));
        viewHandler.openView("busMainView");
    }


    @FXML
    public void backButtonPressed(){
        viewHandler.openView("busMainView");
    }
    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
