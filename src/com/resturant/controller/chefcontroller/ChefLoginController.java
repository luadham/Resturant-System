package com.resturant.controller.chefcontroller;

import com.resturant.controller.ErrorPage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
    private void doLogin() {
        StageFactory stageFactory = null;
        if (InputValidationController.verifyTextField(usernameText, passwordText)
            && LoginController.validateStaff(usernameText.getText(), passwordText.getText())) {
            try {
                stageFactory = new StageFactory(chefLogin);
                stageFactory.getView();
            } catch (Exception e) {
                ErrorPage errorPage = new ErrorPage();
                errorPage.showErrorPage();
            }
        } else {
            InputValidationController.setErrorMessage(errorLabel, "There is Something Wrong");
        }
    }

    @FXML
    private void goToHomePage(ActionEvent event) {
        StageFactory stageFactory = null;
        try {
            stageFactory = new StageFactory(homePageButton);
            stageFactory.getView();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onEnterPressed(KeyEvent event) {
        if (event.getCode().getName().equals("Enter"))
            doLogin();
    }

    public void onLoginPressed(ActionEvent event) {
        doLogin();
    }
}
