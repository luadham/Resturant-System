package sample.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

/**
 * The type Login page controller.
 * @author Adham Adel
 */
public class LoginPageController {
    @FXML
    private void handelButtonAction(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        try {
            StageFactory stageFactory = new StageFactory(clickedButton);
            stageFactory.changeView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
