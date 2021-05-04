package sample.Controller.ManagerController;

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
 * The type Manager login controller.
 * @author Adham Adel
 */
public class ManagerLoginController {
    @FXML
    private TextField usernameText;
    @FXML
    private PasswordField passwordText;
    @FXML
    private Label errorLabel;
    @FXML
    private Button managerLoginButton;
    @FXML
    private Button homePageButton;

    @FXML
    private void usernameAction(KeyEvent event) {
        InputControl.removeErrorMessage(errorLabel);
    }

    @FXML
    private void loginButton(ActionEvent event) {
        if (InputControl.verifyTextField(usernameText, passwordText)
            && LoginControl.validateManager(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(managerLoginButton);
                stageFactory.changeView();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(passwordText.getText());
            InputControl.setErrorMessage(errorLabel, "There is something Wrong!");
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
