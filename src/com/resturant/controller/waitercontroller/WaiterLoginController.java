package com.resturant.controller.waitercontroller;

import com.resturant.controller.ErrorPage;
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
        InputValidationController.clearErrorMessage(errorLabel);
    }
    @FXML
    private void waiterButtonAction(ActionEvent event) {
        if (InputValidationController.verifyTextField(usernameText, passwordText)
            && LoginController.validateStaff(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(waiterLoginButton);
                stageFactory.getView();
            } catch (IOException e) {
                ErrorPage errorPage = new ErrorPage();
                errorPage.showErrorPage();
            }
        } else {
            InputValidationController.setErrorMessage(errorLabel, "There is Something Wrong");
        }
    }

    @FXML
    private void homePageButton(ActionEvent event) {
        try {
            StageFactory stageFactory = new StageFactory(homePageButton);
            stageFactory.getView();
        } catch (IOException e) {
            ErrorPage errorPage = new ErrorPage();
            errorPage.showErrorPage();
        }
    }

}
