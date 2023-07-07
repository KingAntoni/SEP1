package Controller.Bus;


import Controller.ViewHandler;
import Model.Bus;
import Model.ModelManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;

public class BusMainViewController {
    private Region root;
    private ViewHandler viewHandler;
    private ModelManager modelManager;
    @FXML
    TableView<Bus> busTable;

    @FXML
    private TableColumn<Bus, String> typeColumn;

    @FXML
    private TableColumn<Bus, Integer> numberOfSeatsColumn;


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
    public void addBusButtonPressed(){

    }
    @FXML
    public void editBusButtonPressed(){

    }
    @FXML
    public void deleteBusButtonPressed(){

    }

    public void reset() {
    }

    public javafx.scene.layout.Region getRoot() {
        return root;
    }
}
