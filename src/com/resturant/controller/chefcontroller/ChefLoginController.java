package com.resturant.controller.chefcontroller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import com.resturant.controller.InputValidationController;
import com.resturant.controller.LoginController;
import com.resturant.controller.factory.StageFactory;

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
        InputValidationController.clearErrorMessage(errorLabel);
    }


    @FXML
    private void doLoginChef(ActionEvent event) {
        if (InputValidationController.verifyTextField(usernameText, passwordText)
            && LoginController.validateStaff(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(chefLogin);
                stageFactory.getView();
            } catch (IOException e) {
                // some screen to view error
                // some error screen
                e.printStackTrace();
            }
        } else {
            InputValidationController.setErrorMessage(errorLabel, "There is Something Wrong");
        }
    }

    @FXML
    private void homePageButton(ActionEvent event) {
        StageFactory stageFactory = null;
        try {
            stageFactory = new StageFactory(homePageButton);
            stageFactory.getView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
