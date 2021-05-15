package com.resturant.controller.managercontroller;

import com.resturant.controller.ErrorPage;
import com.resturant.controller.factory.StageFactory;
import com.resturant.controller.InputValidationController;
import com.resturant.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

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
        InputValidationController.clearErrorMessage(errorLabel);
    }
    @FXML
    private void doLogin() {
        if (InputValidationController.verifyTextField(usernameText, passwordText)
            && LoginController.validateManager(usernameText.getText(), passwordText.getText())) {
            try {
                StageFactory stageFactory = new StageFactory(managerLoginButton);
                stageFactory.getView();
            } catch (IOException e) {
                ErrorPage errorPage = new ErrorPage();
                errorPage.showErrorPage();
            }
        } else {
            System.out.println(passwordText.getText());
            InputValidationController.setErrorMessage(errorLabel, "There is something Wrong!");
        }
    }
    @FXML
    private void getHomeScreen(ActionEvent event) {
        StageFactory stageFactory = null;
        try {
            stageFactory = new StageFactory(homePageButton);
            stageFactory.getView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onLoginClicked(ActionEvent event) {
        doLogin();
    }
    @FXML
    public void onEnterPressed(KeyEvent event) {
        if (event.getCode().getName().equals("Enter"))
            doLogin();
    }
}
