import Controller.ViewHandler;
import Model.ModelManager;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override public void start(Stage stage) throws Exception
    {

        ModelManager modelManager = new ModelManager();
        ViewHandler viewHandler = new ViewHandler(modelManager);

        viewHandler.start(stage);
    }
}