package sample.Controller.ManagerController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import sample.Controller.StageFactory;

import java.io.IOException;


/**
 * The type Manager home controller.
 * @author Adham Adel
 */
public class ManagerHomeController{

    @FXML
    private Pane changedPane;
    @FXML
    private Button homePageButton;

    /**
     * Initialize.
     * When Scene show Set SalesView
     * @throws IOException the io exception
     */
    @FXML
    public void initialize() throws IOException {
        Pane defaultPane = FXMLLoader.load(getClass().getResource("../../View/ManagerView/SalesView.fxml"));
        changedPane.getChildren().addAll(defaultPane);
    }

    /**
     * @modifies Change The Bane based on which button is Clicked
     * @effects changedPane
     * @param event
     * @throws IOException
     */
    @FXML
    private void handelActionButton(ActionEvent event) throws IOException {
        Button clickedButton = (Button) event.getSource();
        String buttonName = clickedButton.getId();
        BaneFactory baneFactory = new BaneFactory(buttonName);
        baneFactory.changePane(changedPane);
    }

    @FXML
    private void homePageButton(ActionEvent event) {
        try {
            StageFactory stageFactory = new StageFactory(homePageButton);
            stageFactory.changeView();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
