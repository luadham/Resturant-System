package com.resturant.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * The type Error page.
 * @author Adham Adel
 */
public class ErrorPage {
    /**
     * Show error page.
     */
    public void showErrorPage() {
        try {
            Parent errorPage = FXMLLoader.load(getClass().getResource("../view/ErrorPage.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Error Page");
            stage.setResizable(false);
            stage.setScene(new Scene(errorPage));
            stage.show();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
