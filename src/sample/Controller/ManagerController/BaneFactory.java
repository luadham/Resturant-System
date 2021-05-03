package sample.Controller.ManagerController;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import sample.Controller.IStageControl;

import java.io.IOException;

/**
 * The type Bane factory.
 * @author Adham Adel
 */
public class BaneFactory implements IPane {
    private Pane pane;

    /**
     * Instantiates a new Bane factory.
     *
     * @param viewName the view name
     * @throws IOException the io exception
     * @modifies pane
     */
    public BaneFactory(String viewName) throws IOException {
        switch (viewName) {
            case "viewSalesButton":
                pane = FXMLLoader.load(getClass().getResource("../../View/ManagerView/SalesView.fxml"));
                break;
            case "manageFoodButton":
                pane = FXMLLoader.load(getClass().getResource("../../View/ManagerView/ManagerFoodView.fxml"));
                break;
            case "manageStaffButton":
                pane = FXMLLoader.load(getClass().getResource("../../View/ManagerView/ManagerStaffView.fxml"));
                break;
            default:
                System.out.println("View Cannot Found!");
                break;
        }
    }

    @Override
    public void changePane(Pane pane) {
        pane.getChildren().clear();
        pane.getChildren().addAll(this.pane);
    }
}
