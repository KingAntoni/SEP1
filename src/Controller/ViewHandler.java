package Controller;

import Controller.Bus.AddBusController;
import Controller.Bus.BusMainViewController;
import Controller.Bus.EditBusController;
import Controller.Chauffeur.AddChauffeurController;
import Controller.Chauffeur.ChauffeurMainViewController;
import Controller.Chauffeur.EditChauffeurController;
import Controller.Customer.AddCustomerController;
import Controller.Customer.CustomerMainViewController;
import Controller.Customer.EditCustomerController;
import Controller.Trip.AddTripController;
import Controller.Trip.EditTripController;
import Controller.Trip.TripMainViewController;
import Model.ModelManager;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler {
    private Stage primaryStage;
    private Scene currentScene;
    private ModelManager modelManager;
    private AddBusController addBusController;
    private BusMainViewController busMainViewController;
    private EditBusController editBusController;
    private AddChauffeurController addChauffeurController;
    private ChauffeurMainViewController chauffeurMainViewController;
    private EditChauffeurController editChauffeurController;
    private AddCustomerController addCustomerController;
    private CustomerMainViewController customerMainViewController;
    private EditCustomerController editCustomerController;
    private AddTripController addTripController;
    private TripMainViewController tripMainViewController;
    private EditTripController editTripController;
    private MainFXMLController mainFXMLController;

    public ViewHandler(ModelManager modelManager)
    {
        this.modelManager = modelManager;
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        this.currentScene = new Scene(new Region());
        openView("mainFXML");
    }

    public void openView(String id)
    {
        Region root = null;

        switch (id) {
            case "mainFXML" -> root =loadMainFXML("/View/MainFXML.fxml");
            case "addBus" -> root =loadAddBus("/View/Bus/AddBus.fxml");
            case "busMainView" -> root =loadBusMainView("/View/Bus/BusMainView.fxml");
            case "addChauffeur" -> root =loadAddChauffeur("/View/Chauffeur/AddChauffeur.fxml");
            case "chauffeurMainView" ->root = loadChauffeurMainView("/View/Chauffeur/ChauffeurMainView.fxml");
            case "addCustomer"->root=loadAddCustomer("/View/Customer/AddCustomer.fxml");
            case "customerMainView" -> root =loadCustomerMainView("/View/Customer/CustomerMainView.fxml");
            case "addTrip" ->root = loadAddTrip("/View/Trip/AddTrip.fxml");
            case "tripMainView" ->root = loadTripMainView("/View/Trip/TripMainView.fxml");
        }
        setStage(root);

    }

    public void setStage(Region root)
    {
        currentScene.setRoot(root);

        String title = "VIABus";
        if (root.getUserData() != null)
        {
            title += root.getUserData();
        }
        primaryStage.setTitle(title);
        primaryStage.setScene(currentScene);
        primaryStage.setWidth(root.getPrefWidth());
        primaryStage.setHeight(root.getPrefHeight());
        primaryStage.show();
    }

    public void openView(String id, String objectID)
    {
        Region root = null;

        switch (id)
        {
            case "editBus" -> root =loadEditBus("/View/Bus/EditBus.fxml", objectID);
            case "editChauffeur" -> root =loadEditChauffeur("/View/Chauffeur/EditChauffeur.fxml", objectID);
            case "editCustomer" -> root =loadEditCustomer("/View/Customer/EditCustomer.fxml",objectID);
            case "editTrip" -> root =loadEditTrip("/View/Trip/EditTrip.fxml",objectID);
        }
        setStage(root);
    }





    private Region loadMainFXML(String fxmlFile) {
        if (mainFXMLController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                mainFXMLController = loader.getController();
                mainFXMLController.init(this,modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            mainFXMLController.reset();
        }
        return mainFXMLController.getRoot();
    }
    private Region loadAddBus(String fxmlFile) {
        if (addBusController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addBusController = loader.getController();
                addBusController.init(this,modelManager , root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            addBusController.reset();
        }
        return addBusController.getRoot();
    }
    private Region loadBusMainView(String fxmlFile) {
        if (busMainViewController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                busMainViewController = loader.getController();
                busMainViewController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            busMainViewController.reset();
        }
        return busMainViewController.getRoot();
    }

    private Region loadEditBus(String fxmlFile, String licencePlate) {
        if (editBusController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editBusController = loader.getController();
                editBusController.init(this, modelManager, root, licencePlate);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            editBusController.reset();
        }
        return editBusController.getRoot();
    }

    private Region loadAddChauffeur(String fxmlFile) {
        if (addChauffeurController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addChauffeurController = loader.getController();
                addChauffeurController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            addChauffeurController.reset();
        }
        return addChauffeurController.getRoot();
    }
    private Region loadChauffeurMainView(String fxmlFile) {
        if (chauffeurMainViewController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                chauffeurMainViewController = loader.getController();
                chauffeurMainViewController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            chauffeurMainViewController.reset();
        }
        return chauffeurMainViewController.getRoot();
    }

    private Region loadEditChauffeur(String fxmlFile, String chauffeurId) {
        if (editChauffeurController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editChauffeurController = loader.getController();
                editChauffeurController.init(this, modelManager, root, chauffeurId);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            editChauffeurController.reset(chauffeurId);
        }
        return editChauffeurController.getRoot();
    }

    private Region loadAddCustomer(String fxmlFile) {
        if (addCustomerController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addCustomerController = loader.getController();
                addCustomerController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            addCustomerController.reset();
        }
        return addCustomerController.getRoot();
    }
    private Region loadCustomerMainView(String fxmlFile) {
        if (customerMainViewController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                customerMainViewController = loader.getController();
                customerMainViewController.init(this, modelManager , root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            customerMainViewController.reset();
        }
        return customerMainViewController.getRoot();
    }

    private Region loadEditCustomer(String fxmlFile, String customerId) {
        if (editCustomerController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editCustomerController = loader.getController();
                editCustomerController.init(this, modelManager, root, customerId);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            editCustomerController.reset(customerId);
        }
        return editCustomerController.getRoot();
    }

    private Region loadAddTrip(String fxmlFile) {
        if (addTripController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                addTripController = loader.getController();
                addTripController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            addTripController.reset();
        }
        return addTripController.getRoot();
    }

    private Region loadEditTrip(String fxmlFile, String tripId) {
        if (editTripController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                editTripController = loader.getController();
                editTripController.init(this, modelManager, root, tripId);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            editTripController.reset(tripId);
        }
        return editTripController.getRoot();
    }

    private Region loadTripMainView(String fxmlFile) {
        if (tripMainViewController == null) {
            try {
                System.out.println(fxmlFile);
                FXMLLoader loader = new FXMLLoader();

                loader.setLocation(getClass().getResource(fxmlFile));
                Region root = loader.load();
                tripMainViewController = loader.getController();
                tripMainViewController.init(this, modelManager, root);
            } catch (Exception e) {

                e.printStackTrace();
            }
        } else {
            tripMainViewController.reset();
        }
        return tripMainViewController.getRoot();
    }
}