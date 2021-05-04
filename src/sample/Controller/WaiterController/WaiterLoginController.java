package sample.Controller.WaiterController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import sample.Controller.InputControl;
import sample.Controller.LoginControl;
import sample.Controller.StageFactory;

import java.io.IOException;

/**
 * The type Waiter login controller.
 * @author Adham Adel
 */
public class WaiterLoginController {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Button waiterLoginButton;
    @FXML
    private Label errorLabel;
    @FXML
    private Button homePageButton;

    @FXML
    private void usernameAction(KeyEvent event) {
        InputControl.removeErrorMessage(errorLabel);
    }
    @FXML
    private void waiterButtonAction(ActionEvent event) {
        if (InputControl.verifyTextField(usernameText, passwordText)
            && LoginControl.validateStaff(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(waiterLoginButton);
                stageFactory.changeView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            InputControl.setErrorMessage(errorLabel, "There is Something Wrong");
        }
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
