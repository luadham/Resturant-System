package sample.Controller.ChefController;

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
 * The type Chef login controller.
 * @author Adham Adel
 */
public class ChefLoginController {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    Button chefLogin;
    @FXML
    private Label errorLabel;
    @FXML
    private Button homePageButton;

    @FXML
    private void userNameAction(KeyEvent event) {
        InputControl.removeErrorMessage(errorLabel);
    }
    @FXML
    private void chefLoginButtonAction(ActionEvent event) {
        if (InputControl.verifyTextField(usernameText, passwordText)
            && LoginControl.validateStaff(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(chefLogin);
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
        StageFactory stageFactory = null;
        try {
            stageFactory = new StageFactory(homePageButton);
            stageFactory.changeView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
