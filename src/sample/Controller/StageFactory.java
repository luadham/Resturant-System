package sample.Controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * The type Stage factory.
 * @author Adham Adel
 */
public class StageFactory implements IStageControl {
    private Parent root;
    private String stageName;
    private Button clikedButton;
    /**
     * Instantiates a new Stage factory.
     *
     * @param clickedButton the Button clicked
     * @throws IOException the io exception
     */
    public StageFactory(Button clickedButton) throws IOException {
        this.clikedButton = clickedButton;
        switch (clickedButton.getId()) {
            case "managerBtn":
                root = FXMLLoader.load(getClass().getResource("../View/ManagerView/ManagerLoginView.fxml"));
                this.stageName = "Manager Login";
                break;
            case "chefBtn":
                root = FXMLLoader.load(getClass().getResource("../View/ChefView/ChefLoginView.fxml"));
                this.stageName = "Chef Login";
                break;
            case "waiterBtn":
                root = FXMLLoader.load(getClass().getResource("../View/WaiterView/WaiterLoginView.fxml"));
                this.stageName = "Waiter Login";
                break;
            case "managerLoginButton":
                root = FXMLLoader.load(getClass().getResource("../View/ManagerView/ManagerHomeView.fxml"));
                break;
            case "chefLogin":
                root = FXMLLoader.load(getClass().getResource("../View/ChefView/ChefOrderView.fxml"));
                break;
            case "waiterLoginButton":
                root = FXMLLoader.load(getClass().getResource("../View/WaiterView/WaiterGetOrderView.fxml"));
                break;
            case "homePageButton":
                root = FXMLLoader.load(getClass().getResource("../View/LoginPortalView.fxml"));
                this.stageName = "Resturant System";
                break;
            default:
                System.out.println("Scene Not Found");
                break;
        }
    }
    public StageFactory(String stageName) throws IOException {
        switch (stageName) {
            case "mainPage" :
                root = FXMLLoader.load(getClass().getResource("../View/LoginPortalView.fxml"));
                this.stageName = "Resturant System";
                break;
            default:
                break;
        }
    }
    @Override
    public void changeView() {
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setTitle(this.stageName);
        stage.setScene(new Scene(root));
        stage.show();
        if (clikedButton != null) {
            clikedButton.getScene().getWindow().hide();
        }
    }
}
